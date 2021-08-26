package work.metanet.server.usercenter.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import work.metanet.constant.SysConstants;
import work.metanet.base.page.MyPageHelper;
import work.metanet.server.usercenter.repository.DictsRepository;
import work.metanet.server.usercenter.service.DictsService;
import work.metanet.server.usercenter.domain.UcDictionaries;
import work.metanet.base.page.MyPageRequest;
import work.metanet.base.page.MyPageResult;

/**
 * Dictionary管理
 * @author Louis & Edison
 * @date 2020/1/9
 */
@DubboService
@RefreshScope
public class DictsServiceImpl  implements DictsService {
	private static Logger log = LogManager.getLogger(DictsServiceImpl.class);

	@Autowired
	private DictsRepository dictsRepo;

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(UcDictionaries record) {

		dictsRepo.save(record);
		return SysConstants.SUCCUSS;
	}

	@Override
	public int add(UcDictionaries record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String id, UcDictionaries record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UcDictionaries record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<UcDictionaries> findAllSort(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UcDictionaries> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(UcDictionaries record) {
		dictsRepo.deleteById(record.getId());
		return SysConstants.SUCCUSS;
	}

	@Override
	public int delete(List<UcDictionaries> records) {
		for(UcDictionaries record:records) {
			delete(record);
		}
		return SysConstants.SUCCUSS;
	}

	@Override
	public UcDictionaries findById(String id) {
		Optional<UcDictionaries> dict = dictsRepo.findById(id);
		if(dict.isPresent()) {
			return dict.get();
		}
		return null;
	}

	@Override
	public MyPageResult findPage(MyPageRequest pageRequest) {
		//调试信息
		log.log(Level.forName("NOTICE", 450), pageRequest.toJSON());

		Page<UcDictionaries> result = null;
		String label = MyPageHelper.getColumnFilterValue(pageRequest, "label");
		
		Sort sort = Sort.by(Sort.Direction.DESC, "label");
		Pageable page = PageRequest.of(pageRequest.getPageNum() - 1, pageRequest.getPageSize(), sort);
		if(label != null && !label.isEmpty()) {
			result = dictsRepo.findByLabel(label, page);
		} else {
			result = dictsRepo.findAll(page);
		}
				
		// 转换格式
		MyPageResult pageResult = MyPageHelper.getPageResult(result);
		
		//调试信息
		log.log(Level.forName("NOTICE", 450), pageResult.toJSON());
		return pageResult;
	}

	@Override
	public List<UcDictionaries> findByLabel(String label) {
		return dictsRepo.findByLabel(label);
	}

}
