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

import work.metanet.server.usercenter.repository.FmBrowseRepository;
import work.metanet.server.usercenter.service.BrowseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import work.metanet.api.eduResource.vo.EduResourceVo;
import work.metanet.api.fmbrowse.protocol.ReqAddFmBrowse;
import work.metanet.api.fmbrowse.protocol.ReqFmBrowseList;
import work.metanet.api.fmbrowse.protocol.ReqFmBrowseList.RespFmBrowseList;
import work.metanet.base.RespPaging;
import work.metanet.base.page.MyPageRequest;
import work.metanet.base.page.MyPageResult;
import work.metanet.constant.Constant;
import work.metanet.exception.LxException;
import work.metanet.server.usercenter.domain.UcBrowses;
import work.metanet.utils.CosUtil;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DubboService
public class BrowseServiceImpl implements BrowseService{
	
	@Autowired 
	private FmBrowseRepository fmBrowseRepository;
	@Autowired
	private CosUtil cosUtil;
	@Autowired
    private RedisLockRegistry redisLockRegistry;
	@Autowired
	private Constant constant;
	
	/**
	 * @Description: 新增浏览记录
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/03/27
	 */
	@Async
	@Override
	public void addFmBrowse(String userId, ReqAddFmBrowse req) throws Exception {
		Lock lock = redisLockRegistry.obtain(StrUtil.join(":", "BROWSE", userId, req.getResourceId()));
		if(lock.tryLock(constant.getRedis_lock_timeout_seconds(),TimeUnit.SECONDS)) {
			try {
				//log.info("---我拿到了锁哦---:"+lock.toString());
				UcBrowses fmBrowse = fmBrowseRepository.getFmBrowse(userId, req.getResourceId());
				if(fmBrowse!=null) {
					fmBrowseRepository.updateFmBrowseTime(fmBrowse.getId());
				}else {
					UcBrowses browses = UcBrowses.of();
					browses.setContentId(req.getResourceId()).setUserId(userId);
					fmBrowseRepository.save(browses);
					//溢出删除
					fmBrowseRepository.fmBrowseOverflow(userId);
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
	 * @Description: 资源浏览记录列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/03/27
	 */
	@Override
	public RespPaging<RespFmBrowseList> fmBrowseList(String userId, ReqFmBrowseList req) throws Exception {
		RespPaging<RespFmBrowseList> respPaging = new RespPaging<RespFmBrowseList>();
		PageHelper.startPage(req.getPageNum(), req.getPageSize());
		List<RespFmBrowseList> list = fmBrowseRepository.fmBrowseList(userId);
		BeanUtil.copyProperties(new PageInfo<RespFmBrowseList>(list), respPaging);
		for (EduResourceVo eduResourceVo : respPaging.getList()) {
			eduResourceVo.setCoverUrl(cosUtil.getAccessUrl(eduResourceVo.getCoverUrl()));
			eduResourceVo.setFileUrl(cosUtil.getAccessUrl(eduResourceVo.getFileUrl()));
		}
		return respPaging;
	}

	@Override
	public int save(UcBrowses record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(UcBrowses record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String id, UcBrowses record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UcBrowses record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UcBrowses record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(List<UcBrowses> records) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UcBrowses findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyPageResult findPage(MyPageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UcBrowses> findAllSort(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UcBrowses> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
