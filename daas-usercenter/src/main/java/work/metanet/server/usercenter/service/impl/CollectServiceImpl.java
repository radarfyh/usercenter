package work.metanet.server.usercenter.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.scheduling.annotation.Async;

import work.metanet.server.usercenter.repository.FmCollectRepository;
import work.metanet.server.usercenter.service.CollectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import work.metanet.api.eduResource.vo.EduResourceVo;
import work.metanet.api.fmcollect.protocol.ReqAddFmCollect;
import work.metanet.api.fmcollect.protocol.ReqFmCollectList;
import work.metanet.api.fmcollect.protocol.ReqFmCollectList.RespFmCollectList;
import work.metanet.base.RespPaging;
import work.metanet.base.page.MyPageRequest;
import work.metanet.base.page.MyPageResult;
import work.metanet.constant.Constant;
import work.metanet.exception.LxException;
import work.metanet.server.usercenter.domain.UcCollections;
import work.metanet.utils.CosUtil;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DubboService
public class CollectServiceImpl implements CollectService{
	
	@Autowired 
	private FmCollectRepository fmCollectRepository;
	@Autowired
	private CosUtil cosUtil;
	@Autowired
    private RedisLockRegistry redisLockRegistry;
	@Autowired
	private Constant constant;
	
	/**
	 * @Description: 新增收藏
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/03/27
	 */
	@Async
	@Override
	public void addFmCollect(String userId,ReqAddFmCollect req) throws Exception{
		Lock lock = redisLockRegistry.obtain(StrUtil.join(":", "COLLECT",userId,req.getResourceId()));
		if(lock.tryLock(constant.getRedis_lock_timeout_seconds(),TimeUnit.SECONDS)) {
			try {
				//log.info("---我拿到了锁哦---:"+lock.toString());
				UcCollections fmCollect = fmCollectRepository.getFmCollect(userId, req.getResourceId());
				if(fmCollect!=null) {
					fmCollectRepository.delete(fmCollect);
				}else {
					fmCollect = UcCollections.of();
					fmCollect.setResourceId(req.getResourceId()).setUserId(userId);
					fmCollectRepository.save(fmCollect);
				}
			}finally {
				//log.info("---我释放锁了哦---:"+lock.toString());
				lock.unlock();
			}
		}else {
			log.info("---我等待了{}秒还未拿到锁---:{}",constant.getRedis_lock_timeout_seconds(),lock.toString());
    		throw LxException.of().setMsg("服务器繁忙！");
		}
	}
	
	/**
	 * @Description: 资源收藏列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/03/27
	 */
	@Override
	public RespPaging<RespFmCollectList> fmCollectList(String userId, ReqFmCollectList req) throws Exception {
		RespPaging<RespFmCollectList> respPaging = new RespPaging<RespFmCollectList>();
		PageHelper.startPage(req.getPageNum(), req.getPageSize());
		List<RespFmCollectList> list = fmCollectRepository.fmCollectList(userId);
		BeanUtil.copyProperties(new PageInfo<RespFmCollectList>(list), respPaging);
		for (EduResourceVo eduResourceVo : respPaging.getList()) {
			eduResourceVo.setCoverUrl(cosUtil.getAccessUrl(eduResourceVo.getCoverUrl()));
			eduResourceVo.setFileUrl(cosUtil.getAccessUrl(eduResourceVo.getFileUrl()));
		}
		return respPaging;
	}

	@Override
	public int save(UcCollections record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(UcCollections record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String id, UcCollections record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UcCollections record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UcCollections record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(List<UcCollections> records) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UcCollections findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyPageResult findPage(MyPageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UcCollections> findAllSort(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UcCollections> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
