package work.metanet.server.service;


import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import work.metanet.api.thirdBusiness.IThirdBusinessService;
import work.metanet.api.thirdBusiness.protocol.ReqThirdBusinessList;
import work.metanet.api.thirdBusiness.protocol.ReqThirdBusinessList.RespThirdBusinessList;
import work.metanet.base.RespPaging;
import work.metanet.server.dao.ThirdBusinessMapper;

import cn.hutool.core.bean.BeanUtil;

@DubboService
public class ThirdBusinessService implements IThirdBusinessService{
	
	@Autowired
	private ThirdBusinessMapper thirdBusinessMapper;
	
	@Override
	public RespPaging<RespThirdBusinessList> thirdBusinessList(ReqThirdBusinessList req) throws Exception {
		RespPaging<RespThirdBusinessList> respPaging = new RespPaging<RespThirdBusinessList>();
		PageHelper.startPage(req.getPageNum(), req.getPageSize());
		List<RespThirdBusinessList> list = thirdBusinessMapper.thirdBusinessList(BeanUtil.beanToMap(req));
		BeanUtil.copyProperties(new PageInfo<RespThirdBusinessList>(list), respPaging);
		return respPaging;
	}
	
}
