package work.metanet.server.usercenter.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import work.metanet.api.prize.protocol.ReqPrizeStore;
import work.metanet.base.RespPaging;
import work.metanet.base.page.MyPageRequest;
import work.metanet.base.page.MyPageResult;
import work.metanet.constant.ConstCacheKey;
import work.metanet.server.usercenter.domain.UcPrizes;
import work.metanet.server.usercenter.repository.PrizesRepository;
import work.metanet.server.usercenter.service.PrizesService;
import work.metanet.utils.CosUtil;

public class PrizesServiceImpl implements PrizesService {
	@Autowired
	private PrizesRepository prizesRepository;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private CosUtil cosUtil;
	
	@Override
	public RespPaging<UcPrizes> getPrizesList(ReqPrizeStore req) throws Exception {
		RespPaging<UcPrizes> respPaging = new RespPaging<UcPrizes>();
		ConstCacheKey constCacheKey = ConstCacheKey.PRIZE_STORE;
		String cacheKey = constCacheKey.cacheKey(String.valueOf(req.hashCode()));
		Object obj = stringRedisTemplate.opsForValue().get(cacheKey);
		respPaging = JSONUtil.toBean(new JSONObject(obj),RespPaging.class,true);
		if(ObjectUtil.isEmpty(obj)) {
			PageHelper.startPage(req.getPageNum(), req.getPageSize());
			List<UcPrizes> list = prizesRepository.findAllByPackageName(req.getPackageName());
			for (UcPrizes resp : list) {
				resp.setPrizeImg(cosUtil.getAccessUrl(resp.getPrizeImg()));
			}
			BeanUtil.copyProperties(new PageInfo<UcPrizes>(list), respPaging);
			stringRedisTemplate.opsForValue().set(cacheKey, JSONUtil.toJsonStr(respPaging), constCacheKey.getExpire(),TimeUnit.SECONDS);
		}
		return respPaging;
	}
	
	@Override
	public UcPrizes getPrizeByIdLock(String prizeId) {
		return BeanUtil.copyProperties(prizesRepository.getPrizeByIdLock(prizeId), UcPrizes.class);
	}
	
	@Override
	public int updateInventory(String prizeId, Integer number) {
		return prizesRepository.updateInventory(prizeId, number);
	}

	@Override
	public int save(UcPrizes record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(UcPrizes record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String id, UcPrizes record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UcPrizes record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UcPrizes record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(List<UcPrizes> records) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UcPrizes findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyPageResult findPage(MyPageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UcPrizes> findAllSort(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UcPrizes> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
}
