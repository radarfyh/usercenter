package work.metanet.server.usercenter.service.impl;


import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import work.metanet.base.page.MyPageRequest;
import work.metanet.base.page.MyPageResult;
import work.metanet.server.usercenter.domain.UcDiaries;
import work.metanet.server.usercenter.service.DiaryService;

@DubboService
public class DiaryServiceImpl implements DiaryService{

	@Override
	public int save(UcDiaries record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(UcDiaries record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String id, UcDiaries record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UcDiaries record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UcDiaries record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(List<UcDiaries> records) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UcDiaries findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyPageResult findPage(MyPageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UcDiaries> findAllSort(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UcDiaries> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
