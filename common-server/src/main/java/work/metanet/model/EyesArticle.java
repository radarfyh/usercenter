package work.metanet.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * t_eyes_article
 * @author 
 */
@Data
@Accessors(chain = true)
@Table(name = "t_eyes_article")
public class EyesArticle implements Serializable {
    /**
     * 爱眼知识id
     */
	@Id
    private String eyesArticleId;

    /**
     * 爱眼知识标题
     */
    private String eyesArticleTitle;
    
    /**
     * 爱眼知识类型-ARTICLE:文章/VIDEO:视频
     */
    private String eyesArticleType;

    /**
     * 爱眼知识图片
     */
    private String eyesArticleImg;

    /**
     * 爱眼知识地址
     */
    private String eyesArticleUrl;

    /**
     * 爱眼知识内容
     */
    private String eyesArticleContent;

    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date releaseTime;

    /**
     * 浏览次数
     */
    private Integer releaseNumber;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Column(updatable = false)
	private Date createTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Column(updatable = false)
	private Date updateTime;

    /**
     * 数据有效性-0无效/1有效(实体类为boolean)
     */
    private Boolean status;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}