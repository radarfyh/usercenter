package work.metanet.api.eyesArticle.protocol;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author nicely
 * @Description
 * @date 2021年05月21日10:47
 */
@Data
@Accessors(chain = true)
public class RespArticleEdit implements Serializable {

    private static final long serialVersionUID = 1L;

    private String src;

    private String title;
}

