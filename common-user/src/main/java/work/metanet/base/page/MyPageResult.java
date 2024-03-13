package work.metanet.base.page;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * page分页返回结果
 * @author Louis & Edison
 * @date Aug 19, 2018
 */
public class MyPageResult implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4228379117016751556L;

	/**
	 * 当前页码
	 */
	private int pageNum;

	/**
	 * 每页数量
	 */
	private int pageSize;
	/**
	 * 记录总数
	 */
	private long totalSize;
	/**
	 * 页码总数
	 */
	private int totalPages;
	/**
	 * 分页数据
	 */
	private List<?> content;
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
	public long getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<?> getContent() {
		return content;
	}
	public void setContent(List<?> content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "MyPageResult {" +
                "content=\'" + content.toString()+ '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalPages=" + totalPages +
                ", totalSize=" + totalSize +
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
