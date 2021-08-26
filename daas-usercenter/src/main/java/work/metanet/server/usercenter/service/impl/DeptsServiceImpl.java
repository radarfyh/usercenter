package work.metanet.server.usercenter.service.impl;

import java.util.ArrayList;
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
import work.metanet.server.usercenter.repository.DeptsRepository;
import work.metanet.server.usercenter.service.DeptsService;
import work.metanet.server.usercenter.domain.UcDepartments;
import work.metanet.base.page.MyPageRequest;
import work.metanet.base.page.MyPageResult;

/**
 * department/organization管理
 * @author Louis & Edison
 * @date 2020/1/9
 */
@DubboService
@RefreshScope
public class DeptsServiceImpl implements DeptsService {
	private static Logger log = LogManager.getLogger(DeptsServiceImpl.class);

	@Autowired
	private DeptsRepository deptsRepo;

	@Override
	public int save(UcDepartments record) {
		deptsRepo.save(record);
		return SysConstants.SUCCUSS;
	}

	@Override
	public int add(UcDepartments record) {
		deptsRepo.save(record);
		return SysConstants.SUCCUSS;		
	}

	@Override
	public int update(String id, UcDepartments record) {
		if(record.getId() != id) {
			record.setId(id);
		}
		deptsRepo.save(record);
		
		return SysConstants.SUCCUSS;
	}
	
	@Override
	public int update(UcDepartments record) {
		deptsRepo.save(record);
		
		return SysConstants.SUCCUSS;
	}

	@Override
	public int delete(UcDepartments record) {
		deptsRepo.deleteById(record.getId());
		
		return SysConstants.SUCCUSS;
	}

	@Override
	public int delete(String id) {
		deptsRepo.deleteById(id);
		
		return SysConstants.SUCCUSS;
	}

	@Override
	public int delete(List<UcDepartments> records) {
		for(UcDepartments record:records) {
			delete(record);
		}
		return SysConstants.SUCCUSS;
	}

	@Override
	public UcDepartments findById(String id) {
		Optional<UcDepartments> dept = deptsRepo.findById(id);
		if(dept.isPresent()) {
			return dept.get();
		}
		return null;
	}

	@Override
	public MyPageResult findPage(MyPageRequest pageRequest) {
		//调试信息
		log.log(Level.forName("NOTICE", 450), pageRequest.toJSON());
		
		Page<UcDepartments> result = null;
		Pageable page = PageRequest.of(pageRequest.getPageNum() - 1, pageRequest.getPageSize());

		result = deptsRepo.findAll(page);
				
		// 转换格式
		MyPageResult pageResult = MyPageHelper.getPageResult(result);
		//调试信息
		log.log(Level.forName("NOTICE", 450), pageResult.toJSON());
		return pageResult;
	}

	@Override
	public List<UcDepartments> findTree() {
		List<UcDepartments> sysDepts = new ArrayList<>();
		List<UcDepartments> depts = deptsRepo.findAll();
		for (UcDepartments dept : depts) {
			if (dept.getParentId() == null || dept.getParentId().isEmpty()) {
				dept.setLevel(0);
				sysDepts.add(dept);
			}
		}
		findChildren(sysDepts, depts);
		return sysDepts;
	}

	private void findChildren(List<UcDepartments> sysDepts, List<UcDepartments> depts) {
		for (UcDepartments sysDept : sysDepts) {
			List<UcDepartments> children = new ArrayList<>();
			for (UcDepartments dept : depts) {
				if (sysDept.getId() != null && sysDept.getId().equals(dept.getParentId())) {
					dept.setParentName(dept.getName());
					dept.setLevel(sysDept.getLevel() + 1);
					children.add(dept);
				}
			}
			sysDept.setChildren(children);
			findChildren(children, depts);
		}
	}

	@Override
	public Iterable<UcDepartments> findAllSort(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UcDepartments> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
}
