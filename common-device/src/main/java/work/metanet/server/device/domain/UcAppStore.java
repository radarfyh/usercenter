package work.metanet.server.device.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import work.metanet.base.domain.AbstractEntity;

@Accessors(chain = true)
@EqualsAndHashCode(callSuper=false)
@RequiredArgsConstructor(staticName = "of")
@Entity
@Data
public class UcAppStore extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = -8982135855162242635L;
	
	private String channelId;

    /**
     * 应用名称
     */
    private String appName;
    
    private String icon;

    /**
     * 包名
     */
    private String packageName;
    
    /**
     * 调用类名
     */
    private String callClass;

    /**
     * 文件大小(b)字节
     */
    private BigDecimal fileSize;
    
    /**
     * 版本名
     */
    private String versionName;

    /**
     * 版本号
     */
    private String versionCode;

    /**
     * 应用范围-0所有/1指定
     */
    private String appScope;

    /**
     * 下载次数
     */
    private Integer downloadNumber;

    /**
     * 阶段标签，暂未用
     */
    private String phaseTag;

    /**
     * 发布时间
     */
    private Date releaseTime;

    /**
     * 内容类型
     */
    private String contentType;

    /**
     * 开发商
     */
    private String developer;
    
    /**
     * 文件地址
     */
    private String url;

    /**
     * 应用说明
     */
    private String instruction;

    /**
     * 应用截图
     */
    private String images;
    
    private String md5;
    
    private Boolean enable;
}
