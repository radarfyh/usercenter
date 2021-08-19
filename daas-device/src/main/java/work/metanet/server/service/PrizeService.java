package work.metanet.server.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import work.metanet.api.prize.IPrizeService;
import work.metanet.api.prize.protocol.ReqPrizeStore;
import work.metanet.api.prize.protocol.ReqPrizeStore.RespPrizeStore;
import work.metanet.api.prize.vo.PrizeVo;
import work.metanet.base.RespPaging;
import work.metanet.constant.ConstCacheKey;
import work.metanet.server.dao.PrizeMapper;
import work.metanet.utils.CosUtil;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

@DubboService
public class PrizeService implements IPrizeService{

	@Autowired
	private PrizeMapper prizeMapper;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private CosUtil cosUtil;
	
	@Override
	public RespPaging<RespPrizeStore> prizeStore(ReqPrizeStore req) throws Exception {
		RespPaging<RespPrizeStore> respPaging = new RespPaging<RespPrizeStore>();
		ConstCacheKey constCacheKey = ConstCacheKey.PRIZE_STORE;
		String cacheKey = constCacheKey.cacheKey(String.valueOf(req.hashCode()));
		Object obj = stringRedisTemplate.opsForValue().get(cacheKey);
		respPaging = JSONUtil.toBean(new JSONObject(obj),RespPaging.class,true);
		if(ObjectUtil.isEmpty(obj)) {
			PageHelper.startPage(req.getPageNum(), req.getPageSize());
			List<RespPrizeStore> list = prizeMapper.prizeStore(req);
			for (RespPrizeStore resp : list) {
				resp.setPrizeImg(cosUtil.getAccessUrl(resp.getPrizeImg()));
			}
			BeanUtil.copyProperties(new PageInfo<RespPrizeStore>(list), respPaging);
			stringRedisTemplate.opsForValue().set(cacheKey, JSONUtil.toJsonStr(respPaging), constCacheKey.getExpire(),TimeUnit.SECONDS);
		}
		return respPaging;
	}
	
	@Override
	public PrizeVo getPrizeVoByIdLock(String prizeId) {
		return BeanUtil.copyProperties(prizeMapper.getPrizeVoByIdLock(prizeId), PrizeVo.class);
	}
	
	@Override
	public int updatePrizeInventory(String prizeId, Integer number) {
		return prizeMapper.updatePrizeInventory(prizeId, number);
	}
	
}
