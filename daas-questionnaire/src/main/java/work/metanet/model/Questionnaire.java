
package work.metanet.model;

import java.io.Serializable;

import javax.persistence.Table;

/**
 * @author Edison F.
 * @Description Model: 调查表 t_questionnaire
 * @DateTime 2023/04/18
 */
@Table(name = "t_questionnaire")
public class Questionnaire extends QuestionnaireBase  implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6832022614391935912L;

}
