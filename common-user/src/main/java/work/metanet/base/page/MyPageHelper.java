package work.metanet.base.page;

import java.util.List;

import org.springframework.data.domain.Page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import work.metanet.base.ColumnFilter;
import work.metanet.utils.ReflectionUtils;

/**
  * 分页查询助手
 * @author Louis & Edison
 * @date Aug 19, 2018
 */
public class MyPageHelper {

	public static final String findPage = "findPage";
	
	/**
	 * 分页查询, 约定查询方法名为 “findPage” 
	 * @param pageRequest 分页请求
	 * @param Dao对象	
	 * @param args 方法参数
	 * @return
	 */
	public static MyPageResult findPage(MyPageRequest pageRequest, Object repository) {
		return findPage(pageRequest, repository, findPage);
	}
	
	/**
	 * 调用分页插件进行分页查询
	 * @param pageRequest 分页请求
	 * @param Dao对象	
	 * @param queryMethodName 要分页的查询方法名
	 * @param args 方法参数
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static MyPageResult findPage(MyPageRequest pageRequest, Object repository, String queryMethodName, Object... args) {
		// 设置分页参数
		int pageNum = pageRequest.getPageNum();
		int pageSize = pageRequest.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		// 利用反射调用查询方法
		Object result = ReflectionUtils.invoke(repository, queryMethodName, args);
		return getPageResult(pageRequest, new PageInfo((List) result));
	}

	/**
	 * 将分页信息封装到统一的接口
	 * @param pageRequest 
	 * @param page
	 * @return
	 */
	private static MyPageResult getPageResult(MyPageRequest pageRequest, PageInfo<?> pageInfo) {
		MyPageResult pageResult = new MyPageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
		return pageResult;
	}

	/**
	 * 将分页信息封装到统一的接口
	 * @param pageRequest 
	 * @param page
	 * @return
	 */
	public static MyPageResult getPageResult(Page<?> page) {
		MyPageResult pageResult = new MyPageResult();
		pageResult.setPageNum(page.getNumber() + 1);
		pageResult.setPageSize(page.getSize());
		pageResult.setTotalSize(page.getTotalElements());
		pageResult.setTotalPages(page.getTotalPages());
		pageResult.setContent(page.getContent());
		return pageResult;
	}
	
	/**
	 * 获取过滤字段的值
	 * @param filterName
	 * @return
	 */
	public static String getColumnFilterValue(MyPageRequest pageRequest, String filterName) {
		String value = null;
		ColumnFilter columnFilter = pageRequest.getColumnFilter(filterName);
		if(columnFilter != null) {
			value = columnFilter.getValue();
		}
		return value;
	}
}
