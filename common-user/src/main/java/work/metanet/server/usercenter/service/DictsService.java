package work.metanet.server.usercenter.service;

import java.util.List;

import work.metanet.server.usercenter.domain.UcDictionaries;
import work.metanet.base.service.CurdService;


/**
 * dictionary管理
 * @author Louis & Edison
 * @date Oct 29, 2018
 */
public interface DictsService extends CurdService<UcDictionaries> {

	/**
	 * 根据名称查询
	 * @param label
	 * @return
	 */
	List<UcDictionaries> findByLabel(String label);
}
