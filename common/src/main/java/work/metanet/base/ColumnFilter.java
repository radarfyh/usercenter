package work.metanet.base;

import java.io.Serializable;

/**
 * page分页查询列过滤器
 * @author Louis & Edison
 * @date Aug 19, 2018
 */
public class ColumnFilter implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2923376160250482930L;
	/**
	 * 过滤列名
	 */
	private String name;
	/**
	 * 查询的值
	 */
	private String value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
