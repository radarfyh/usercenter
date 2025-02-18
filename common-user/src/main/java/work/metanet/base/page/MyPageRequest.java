package work.metanet.base.page;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import work.metanet.base.ColumnFilter;

/**
 * page分页请求
 * @author Louis & Edison
 * @date Aug 19, 2018
 */
public class MyPageRequest implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -614524718184472006L;
	/**
	 * 当前页码
	 */
	private int pageNum = 1;
	/**
	 * 每页数量
	 */
	private int pageSize = 10;
	/**
	 * 列过滤器
	 */
	private Map<String, ColumnFilter> columnFilters = new HashMap<String, ColumnFilter>();
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Map<String, ColumnFilter> getColumnFilters() {
		return columnFilters;
	}
	public void setColumnFilters(Map<String, ColumnFilter> columnFilters) {
		this.columnFilters = columnFilters;
	}
	public ColumnFilter getColumnFilter(String name) {
		return columnFilters.get(name);
	}
	@Override
	public String toString() {
		return "MyPageResult {" +
                "columnFilters=\'" + columnFilters.toString()+ '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
	}
	public String toJSON() {
		ObjectMapper objectMapper = new ObjectMapper();
        String userJson = "";
		try {
			userJson = objectMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "异常：" + e.getMessage();
		}
		return userJson;
	}
}
