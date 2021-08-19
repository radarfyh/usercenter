package work.metanet.server.usercenter.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import work.metanet.api.app.IAppService;
import work.metanet.api.app.vo.AppVo;
import work.metanet.api.storeApp.protocol.ReqSaveStoreApp;
import work.metanet.api.storeApp.protocol.ReqSearchStoreApp;
import work.metanet.api.storeApp.protocol.ReqStoreAppInfo;
import work.metanet.api.storeApp.protocol.ReqStoreAppList;
import work.metanet.base.RespPaging;
import work.metanet.base.page.MyPageRequest;
import work.metanet.base.page.MyPageResult;
import work.metanet.constant.ConstCacheKey;
import work.metanet.constant.ConstUpgradeScore;
import work.metanet.exception.MetanetException;
import work.metanet.exception.ResultResponseEnum;
import work.metanet.server.usercenter.domain.UcAppStore;
import work.metanet.server.usercenter.repository.AppStoreRepository;
import work.metanet.server.usercenter.service.AppStoreService;
import work.metanet.util.redis.RedisHelper;
import work.metanet.utils.CosUtil;

@DubboService
public class AppStoreServiceImpl implements AppStoreService {

	@Autowired
	private AppStoreRepository appStoreRepository;
	@Autowired
	private CosUtil cosUtil;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisHelper redisHelper;
	@DubboReference
	private IAppService appService;
	
	@Override
	public RespPaging<UcAppStore> searchStoreApp(ReqSearchStoreApp req) throws Exception {
		RespPaging<UcAppStore> respPaging = new RespPaging<UcAppStore>();
		AppVo appVo = appService.getAppByPackageName(req.getPackageName());
		req.setChannelId(appVo.getChannelId());
		String cacheKey = ConstCacheKey.STORE_APP.cacheKey(String.valueOf(req.hashCode()));
		Object obj = stringRedisTemplate.opsForValue().get(cacheKey);
		respPaging = JSONUtil.toBean(new JSONObject(obj),RespPaging.class,true);
		if(ObjectUtil.isEmpty(obj)) {
			PageHelper.startPage(req.getPageNum(), req.getPageSize());
			List<UcAppStore> list = appStoreRepository.findAll();
			for (UcAppStore resp : list) {
				resp.setIcon(cosUtil.getAccessUrl(resp.getIcon()));
				resp.setUrl(cosUtil.getAccessUrl(resp.getUrl()));
				if(resp.getFileSize()!=null)resp.setFileSize(resp.getFileSize().divide(BigDecimal.valueOf(1024*1024)).setScale(2, BigDecimal.ROUND_HALF_UP));
			}
			BeanUtil.copyProperties(new PageInfo<UcAppStore>(list), respPaging);
			stringRedisTemplate.opsForValue().set(cacheKey, JSONUtil.toJsonStr(respPaging), ConstCacheKey.STORE_APP.getExpire(),TimeUnit.SECONDS);
		}
		return respPaging;
	}
	
	@Override
	public RespPaging<UcAppStore> storeAppList(ReqStoreAppList req) throws Exception {
		RespPaging<UcAppStore> respPaging = new RespPaging<UcAppStore>();
		PageHelper.startPage(req.getPageNum(), req.getPageSize());
		List<UcAppStore> list = appStoreRepository.findAll();
		for (UcAppStore resp : list) {
			resp.setIcon(cosUtil.getAccessUrl(resp.getIcon()));
			resp.setUrl(cosUtil.getAccessUrl(resp.getUrl()));
			if(resp.getFileSize()!=null)resp.setFileSize(resp.getFileSize().divide(BigDecimal.valueOf(1024*1024)).setScale(2, BigDecimal.ROUND_HALF_UP));
		}
		BeanUtil.copyProperties(new PageInfo<UcAppStore>(list), respPaging);
		return respPaging;
	}

	@Override
	public UcAppStore storeAppInfo(ReqStoreAppInfo req) throws Exception {
		UcAppStore resp;
		
		Optional<UcAppStore> respOptional = appStoreRepository.findById(req.getStoreAppId());
		if (respOptional.isPresent()) {
			resp = respOptional.get();
		}
		else {
			return null;
		}
		resp.setUrl(cosUtil.getAccessUrl(resp.getUrl()));
		resp.setIcon(cosUtil.getAccessUrl(resp.getIcon()));
		if(StrUtil.isNotBlank(resp.getImages())) {
			List<String> imgs = new ArrayList<String>();
			for(String img : StrUtil.split(resp.getImages(), ',')) {
				imgs.add(cosUtil.getAccessUrl(img));
			}
			resp.setImages(StrUtil.join(",", imgs));
		}

		return resp;
	}

	@Override
	@Transactional
	public void saveStoreApp(ReqSaveStoreApp req) throws Exception {
		if(ConstUpgradeScore.SPECIFIED.getVal().equals(req.getAppScope()) && CollectionUtil.isEmpty(req.getStoreAppScopeInfoList())) 
			throw MetanetException.of().setMsg("指定范围不能为空，请选择！");
		
		UcAppStore storeApp = UcAppStore.of();
		BeanUtil.copyProperties(req, storeApp);
		
		storeApp.setUrl(cosUtil.filterUrlDomain(storeApp.getUrl()));
		storeApp.setIcon(cosUtil.filterUrlDomain(storeApp.getIcon()));
		if(StrUtil.isNotBlank(storeApp.getImages())) {
			List<String> imgs = new ArrayList<String>();
			for(String img : StrUtil.split(storeApp.getImages(), ',')) {
				imgs.add(cosUtil.filterUrlDomain(img));
			}
			storeApp.setImages(StrUtil.join(",", imgs));
		}
		
		UcAppStore dbStoreApp = appStoreRepository.findOneByPackageName(storeApp.getPackageName());
		
		if(StringUtils.isNotBlank(storeApp.getId())) {
			//修改操作
			if(!BeanUtil.isEmpty(dbStoreApp) && !dbStoreApp.getId().equals(storeApp.getId()))
				throw MetanetException.of().setMsg("包名已存在");
			if(BeanUtil.isEmpty(dbStoreApp) || dbStoreApp.getId().equals(storeApp.getId())) {
				appStoreRepository.save(storeApp);
				
			}else {
				throw MetanetException.of(ResultResponseEnum.FAILURE_ACTIVATE.resultResponse());				
			}
		}else {
			//新增操作
			if(!BeanUtil.isEmpty(dbStoreApp)) throw MetanetException.of().setMsg("包名已存在");
			String storeAppId = IdUtil.fastSimpleUUID();
			storeApp.setId(storeAppId);
			appStoreRepository.save(storeApp);
		}
		
		redisHelper.keys(ConstCacheKey.STORE_APP.cacheKey("*")).forEach(key->{
			stringRedisTemplate.delete(key);
		});
	}

	@Override
	public void removeStoreApp(List<UcAppStore> req) throws Exception {
		appStoreRepository.deleteAll(req);;
		redisHelper.keys(ConstCacheKey.STORE_APP.cacheKey("*")).forEach(key->{
			stringRedisTemplate.delete(key);
		});
	}

	@Override
	public int save(UcAppStore record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(UcAppStore record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String id, UcAppStore record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UcAppStore record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UcAppStore record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(List<UcAppStore> records) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UcAppStore findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyPageResult findPage(MyPageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UcAppStore> findAllSort(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UcAppStore> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
}
