package work.metanet.server.usercenter.service.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import work.metanet.constant.SysConstants;
import work.metanet.base.page.MyPageHelper;
import work.metanet.server.usercenter.repository.LogsRepository;
import work.metanet.server.usercenter.service.LogsService;
import work.metanet.server.usercenter.domain.UcLogs;
import work.metanet.base.page.MyPageRequest;
import work.metanet.base.page.MyPageResult;

/**
 * log管理
 * @author Louis & Edison
 * @date 2020/1/9
 */
@DubboService
@RefreshScope
public class LogsServiceImpl  implements LogsService {
	private static Logger log = LogManager.getLogger(LogsServiceImpl.class);

	@Resource
	private LogsRepository logsRepo;

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(UcLogs record) {

		logsRepo.save(record);
		return SysConstants.SUCCUSS;
	}

	@Override
	public int add(UcLogs record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String id, UcLogs record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UcLogs record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<UcLogs> findAllSort(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UcLogs> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(UcLogs record) {
		logsRepo.delete(record);
		return SysConstants.SUCCUSS;
	}

	@Override
	public int delete(List<UcLogs> records) {
		for(UcLogs record:records) {
			delete(record);
		}
		return SysConstants.SUCCUSS;
	}

	@Override
	public UcLogs findById(String id) {
		Optional<UcLogs> log = logsRepo.findById(id);
		if(log.isPresent()) {
			return log.get();
		}
		return null;
	}

	@Override
	public MyPageResult findPage(MyPageRequest pageRequest) {
		//调试信息
		log.log(Level.forName("NOTICE", 450), pageRequest.toJSON());

		Page<UcLogs> result = null;
		String name = MyPageHelper.getColumnFilterValue(pageRequest, "userName");
		
		Sort sort = Sort.by(Sort.Direction.DESC, "userName");
		Pageable page = PageRequest.of(pageRequest.getPageNum() - 1, pageRequest.getPageSize(), sort);
		if(name !=null && !name.isEmpty()) {
			result = logsRepo.findByUserName(name, page);
		} else {
			result = logsRepo.findAll(page);
		}
				
		// 转换格式
		MyPageResult pageResult = MyPageHelper.getPageResult(result);
		//调试信息
		log.log(Level.forName("NOTICE", 450), pageResult.toJSON());
		
		return pageResult;
	}
	
}
