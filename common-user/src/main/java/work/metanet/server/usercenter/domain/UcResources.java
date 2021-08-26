package work.metanet.server.usercenter.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import work.metanet.base.domain.AbstractEntity;

/**
 * resource资源 模型
 * @author Louis & Edison
 * @date Oct 29, 2018
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@Entity
@Data
public class UcResources extends AbstractEntity implements Serializable {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 551712748803326168L;

	private String parentId;

    private String name;

    // 资源URL,
    // 类型：1.普通页面（如用户管理， /sys/user） 
    // 2.嵌套完整外部页面，以http(s)开头的链接 
    // 3.嵌套服务器页面，使用iframe:前缀+目标URL(如SQL监控， iframe:/druid/login.html, iframe:前缀会替换成服务器地址)
    // 4.表记录，使用rec:{tablename}/{id}，其中多个tablename使用逗号分隔，多个id使用逗号分隔
    private String url;

    // 授权(多个用逗号分隔，如：sys:user:add,sys:user:edit)
    private String perms;

    // 类型 0：目录/元数据   1：菜单   2：按钮 3：信息项/数据记录
    private Integer resourceType;

    private String icon;

    private Integer sort;
    // 非数据库字段
    @Transient
    private String parentName;
    // 非数据库字段
    @Transient
    private Integer level;
    // 非数据库字段
    @Transient
    private List<UcResources> children;
    

}