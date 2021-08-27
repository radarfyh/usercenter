package work.metanet.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author nicely
 * @Description
 * @date 2021年05月25日11:23
 */
@Data
@Accessors(chain = true)
public class EyesArticleExerciseBase implements Serializable {

	private static final long serialVersionUID = 3321425534399806854L;

	/**
     * 关系id
     */
    private String articleExerciseId;

    /**
     * 内容id
     */
    private String eyesArticleId;

    /**
     * 锻炼活动id
     */
    private String exerciseId;
}

