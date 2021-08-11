package work.metanet.server.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import work.metanet.api.business.IBusinessService;
import work.metanet.api.business.protocol.ReqBusinessInfo;
import work.metanet.api.business.protocol.ReqBusinessInfo.RespBusinessInfo;
import work.metanet.api.business.protocol.ReqBusinessList;
import work.metanet.api.business.protocol.ReqBusinessList.RespBusinessList;
import work.metanet.api.business.protocol.ReqRemoveBusiness;
import work.metanet.api.business.protocol.ReqSaveBusiness;
import work.metanet.api.business.protocol.ReqSaveBusiness.RespSaveBusiness;
import work.metanet.base.RespPaging;

import work.metanet.exception.MetanetException;
import work.metanet.exception.ResultResponseEnum;
import work.metanet.model.Business;
import work.metanet.server.dao.BusinessMapper;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;

@DubboService
public class BusinessService implements IBusinessService{

	@Autowired
	private BusinessMapper businessMapper;
	
	/**
	 * @Description: 内容商列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	@Override
	public RespPaging<RespBusinessList> businessList(ReqBusinessList req) throws Exception {
		RespPaging<RespBusinessList> respPaging = new RespPaging<RespBusinessList>();
		PageHelper.startPage(req.getPageNum(), req.getPageSize());
		List<RespBusinessList> list = businessMapper.businessList(BeanUtil.beanToMap(req));
		BeanUtil.copyProperties(new PageInfo<RespBusinessList>(list), respPaging);
		return respPaging;
	}

	/**
	 * @Description: 内容商信息
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	@Override
	public RespBusinessInfo businessInfo(ReqBusinessInfo req) throws Exception {
		RespBusinessInfo resp = businessMapper.businessInfo(BeanUtil.beanToMap(req));
		return resp;
	}

	/**
	 * @Description: 保存内容商
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	@Override
	public RespSaveBusiness saveBusiness(ReqSaveBusiness req) throws Exception {
		Business business = new Business();
		BeanUtil.copyProperties(req, business);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("businessCode", req.getBusinessCode());
		Business dbBusiness = businessMapper.getBusiness(map);
		
		if(StringUtils.isNotBlank(business.getBusinessId())) {
			//修改操作
			if(!BeanUtil.isEmpty(dbBusiness) && !dbBusiness.getBusinessId().equals(business.getBusinessId())) 
				throw MetanetException.of().setMsg("内容商代码已存在");
			if(BeanUtil.isEmpty(dbBusiness) || dbBusiness.getBusinessId().equals(business.getBusinessId())) {
				businessMapper.updateByPrimaryKeySelective(business);				
			}else {
				throw MetanetException.of().setResult(ResultResponseEnum.SERVER_FAILURE.resultResponse());				
			}
		}else {
			//新增操作
			if(!BeanUtil.isEmpty(dbBusiness))
				throw MetanetException.of().setMsg("内容商代码已存在");
			business.setBusinessId(IdUtil.fastSimpleUUID());
			businessMapper.insertSelective(business);
		}
		
		RespSaveBusiness resp = new RespSaveBusiness();
		BeanUtil.copyProperties(business, resp);
		return resp;
	}

	/**
	 * @Description: 删除内容商
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	@Override
	public void removeBusiness(List<ReqRemoveBusiness> req) throws Exception {
		businessMapper.removeBusiness(req);
	}
	
	
	
	
	
	
	
	
}
