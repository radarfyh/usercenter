package work.metanet.api.vision;

import java.util.List;

import work.metanet.api.vision.protocol.ReqRemoveVisionExercise;
import work.metanet.api.vision.protocol.ReqSaveVisionExercise;
import work.metanet.api.vision.protocol.ReqSaveVisionExercise.RespSaveVisionExercise;
import work.metanet.api.vision.protocol.ReqVisionExerciseInfo;
import work.metanet.api.vision.protocol.ReqVisionExerciseInfo.RespVisionExerciseInfo;
import work.metanet.api.vision.protocol.ReqVisionExerciseList;
import work.metanet.api.vision.protocol.ReqVisionExerciseList.RespVisionExerciseList;
import work.metanet.base.RespPaging;

/**
 * @author EdisonFeng
 * @Description 视力锻炼，用于rpc服务
 * @DateTime 2021年5月15日
 * Copyright(c) 2021. All Rights Reserved
 */
public interface IVisionExercise {
	/**
	 * @Description: 查询列表
	 * @Author Edison F.
	 * @DateTime 2021/07/14
	 */
	RespPaging<RespVisionExerciseList> getVisionExerciseList(ReqVisionExerciseList req) throws Exception;
	
	/**
	 * @Description: 查询详情
	 * @Author Edison F.
	 * @DateTime 2021/07/14
	 */
	RespVisionExerciseInfo getVisionExerciseInfo(ReqVisionExerciseInfo req) throws Exception;
	
	/**
	 * @return 
	 * @Description: 保存信息
	 * @Author Edison F.
	 * @DateTime 2021/07/14
	 */
	RespSaveVisionExercise saveVisionExercise(ReqSaveVisionExercise req) throws Exception;
	
	/**
	 * @Description: 增加信息
	 * @Author Edison F.
	 * @DateTime 2021/07/14
	 */
	RespSaveVisionExercise insertVisionExercise(ReqSaveVisionExercise req) throws Exception;
	
	/**
	 * @Description: 删除信息
	 * @Author Edison F.
	 * @DateTime 2021/07/14
	 */
	List<ReqRemoveVisionExercise> removeVisionExercise(List<ReqRemoveVisionExercise> tests) throws Exception;
}
