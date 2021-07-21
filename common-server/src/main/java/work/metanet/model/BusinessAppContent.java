package work.metanet.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * t_business_app_content
 * @author 
 */
@Data
@Table(name = "t_business_app")
public class BusinessAppContent implements Serializable {
    /**
     * 内容商产品内容id
     */
	@Id
    private String businessAppContentId;

    /**
     * 内容商产品id
     */
    private String businessAppId;

    /**
     * 内容商内容id
     */
    private String businessContentId;

    private static final long serialVersionUID = 1L;
}