package work.metanet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * t_app_earnings_setting
 * @author 
 */
@Table(name = "t_app_earnings_setting")
@Data
public class AppEarningsSetting implements Serializable {
    /**
     * 产品收益设置id
     */
	@Id
    private String appEarningsSettingId;

    /**
     * 产品id
     */
    private String appId;

    /**
     * 第三方内容商id
     */
    private String thirdBusinessId;

    /**
     * 结算比率%
     */
    private Double settlementRatio;

    /**
     * 备注-内部使用
     */
    private String remark;

    /**
     * 创建时间,默认系统时间,不需要手动插入
     */
    private Date createTime;

    /**
     * 创建者id
     */
    private String createUser;

    /**
     * 修改者id
     */
    private String updateUser;

    /**
     * 数据有效性-0无效/1有效(实体类为boolean)
     */
    private Boolean status;

    private static final long serialVersionUID = 1L;
}