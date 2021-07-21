package work.metanet.server.usercenter.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.StringRedisTemplate;

import work.metanet.server.usercenter.repository.FamilyMemberRepository;
import work.metanet.server.usercenter.repository.UsersRepository;
import work.metanet.server.usercenter.service.MemberService;
import work.metanet.api.family.protocol.ReqFamilyMemberInfo;
import work.metanet.api.family.protocol.ReqFamilyMemberInfo.RespFamilyMemberInfo;
import work.metanet.api.family.protocol.ReqFamilyMemberList.RespFamilyMemberList;
import work.metanet.api.family.protocol.ReqGrowthRecord;
import work.metanet.api.family.protocol.ReqGrowthRecord.RespGrowthRecord;
import work.metanet.api.family.protocol.ReqGrowthRecord.RespGrowthRecordVaccine;
import work.metanet.api.family.protocol.ReqRemoveFamilyMember;
import work.metanet.api.family.protocol.ReqSaveFamilyMember;
import work.metanet.api.family.protocol.ReqSaveFamilyMember.RespSaveFamilyMember;
import work.metanet.base.page.MyPageRequest;
import work.metanet.base.page.MyPageResult;
import work.metanet.constant.ConstCacheKey;
import work.metanet.exception.LxException;
import work.metanet.server.usercenter.domain.UcFamilyMembers;
import work.metanet.server.usercenter.domain.UcUsers;
import work.metanet.utils.CosUtil;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

@DubboService
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private FamilyMemberRepository familyMemberRepository;
	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private CosUtil cosUtil;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	/**
	 * @Description: 成长记录
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/04/14
	 */
	@Override
	public RespGrowthRecord growthRecord(ReqGrowthRecord req) throws Exception {
		String cacheKey = ConstCacheKey.FM_GROWTH_RECORD.cacheKey(req.getUserId());
		Object value = stringRedisTemplate.opsForHash().get(cacheKey, req.getMonth());
		RespGrowthRecord resp = new RespGrowthRecord();
		if(stringRedisTemplate.hasKey(cacheKey) && value!=null) {
			resp = JSONUtil.toBean(new JSONObject(value), RespGrowthRecord.class);
		}else {
			Map<String, Object> monthAgeMap = familyMemberRepository.getMonthAge(req.getUserId(), req.getMonth());
			List<Map<String, String>> standardList = familyMemberRepository.getStandardHeightAndWeight(req.getUserId(), req.getMonth());
			List<RespGrowthRecordVaccine> vaccineList = familyMemberRepository.vaccineList(req.getUserId(), req.getMonth());
			
			StringBuffer sb = new StringBuffer("亲爱的{nick_name}，今天你{age}岁");
			if(Convert.toInt(monthAgeMap.get("month"))>0) {
				sb.append(monthAgeMap.get("month")).append("个月");
			}
			sb.append("了，快量一下身高体重是不是在这个范围哦：");
			for (Map<String, String> map : standardList) {
				if(map.get("standard_type").equals("HEIGHT")) {
					sb.append(" 身高:").append(map.get("value")).append("CM");
				}
				if(map.get("standard_type").equals("WEIGHT")) {
					sb.append(" 体重:").append(map.get("value")).append("KG");
				}
			}
			resp.setInfo(
					StrUtil.format(sb.toString(), MapUtil.builder()
							.put("nick_name", monthAgeMap.get("nick_name")) 
							.put("age", monthAgeMap.get("age"))
							.build()
							)
					);
			resp.setVaccineList(vaccineList);
			stringRedisTemplate.opsForHash().put(cacheKey, req.getMonth(), JSONUtil.toJsonStr(resp));
			stringRedisTemplate.expire(cacheKey, ConstCacheKey.FM_GROWTH_RECORD.getExpire(),TimeUnit.SECONDS);
		}
		return resp;
	}
	
	@Override
	public List<RespFamilyMemberList> familyMemberList(String joinUserId) throws Exception {
		List<RespFamilyMemberList> list = familyMemberRepository.familyMemberList(joinUserId);
		for (RespFamilyMemberList resp : list) {
			resp.setHeadUrl(cosUtil.getAccessUrl(resp.getHeadUrl()));
		}
		return list;
	}
	
	
	@Override
	public RespFamilyMemberInfo familyMemberInfo(ReqFamilyMemberInfo req) throws Exception{
		RespFamilyMemberInfo resp = null;
		Optional<UcFamilyMembers> familyMember = familyMemberRepository.findById(req.getFamilyMemberId());
		if(familyMember.isPresent()) {
			resp = new RespFamilyMemberInfo();
			BeanUtil.copyProperties(familyMember, resp);
			resp.setHeadUrl(cosUtil.getAccessUrl(resp.getHeadUrl()));
		}
		return resp;
	}
	
	
	@Override
	public RespSaveFamilyMember saveFamilyMember(ReqSaveFamilyMember req) throws Exception{
		if(req.getBirthday()!=null) {
			req.setAge(DateUtil.ageOfNow(req.getBirthday()));			
		}
		UcUsers user = new UcUsers();
		BeanUtil.copyProperties(req, user);
		user.setHeadUrl(cosUtil.filterUrlDomain(req.getHeadUrl()));
		userRepository.save(user);
		
		UcFamilyMembers familyMember = new UcFamilyMembers();
		BeanUtil.copyProperties(req, familyMember);
		
		if(StringUtils.isNotEmpty(req.getFamilyMemberId())) {
			//修改
			familyMemberRepository.save(familyMember);
		}else {
			//新增
			if(familyMemberRepository.existRelationName(req.getJoinUserId(), req.getRelationName()))
				throw LxException.of().setMsg("家庭角色已存在");
			
			familyMemberRepository.save(familyMember);
		}
		
		RespSaveFamilyMember resp = null;
		
		if(familyMember!=null) {
			resp = new RespSaveFamilyMember();
			BeanUtil.copyProperties(user, resp);
			BeanUtil.copyProperties(familyMember, resp);
			resp.setHeadUrl(cosUtil.getAccessUrl(resp.getHeadUrl()));
			resp.setBirthday(DateUtil.formatDate(user.getBirthday()));
			stringRedisTemplate.delete(ConstCacheKey.FM_GROWTH_RECORD.cacheKey(req.getJoinUserId()));
		}
		
		return resp;
	}
	
	
	/**
	 * @Description: 删除家庭成员
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	@Override
	public void removeFamilyMember(ReqRemoveFamilyMember req) throws Exception {
		familyMemberRepository.removeFamilyMember(req.getFamilyMemberId(), req.getUserId());
	}

	@Override
	public int save(UcFamilyMembers record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(UcFamilyMembers record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String id, UcFamilyMembers record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UcFamilyMembers record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UcFamilyMembers record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(List<UcFamilyMembers> records) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UcFamilyMembers findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyPageResult findPage(MyPageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UcFamilyMembers> findAllSort(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UcFamilyMembers> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
