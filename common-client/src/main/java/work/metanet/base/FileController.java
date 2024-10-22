package work.metanet.base;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import work.metanet.aop.ApiModule;
import work.metanet.aop.ApiModule.Module;
import work.metanet.aop.ApiOperLog;
import work.metanet.aop.ApiOperLog.ACTION;
import work.metanet.aop.ApiPermission.AUTH;
import work.metanet.exception.ResultResponse;
import work.metanet.exception.ResultResponseEnum;
import work.metanet.aop.ApiPermission;
import work.metanet.web.utils.CosUtil;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApiModule(module = Module.FILE)
@Api(tags = { "文件" })
@RestController
@RequestMapping("api/file")
public class FileController {

	@Autowired
	private CosUtil cosUtil;
	
	/**
	 * @Description: 文件上传获取详细信息
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/27
	 */
	@ApiPermission(AUTH.OPEN)
	@ApiOperLog(action = ACTION.UPLOAD, desc = "获取详细信息")
	@ApiOperation(value = "上传文件-获取详细信息")
	@PostMapping(value = "upload", headers = "content-type=multipart/form-data")
	public ResultResponse<RespUpload> upload(@RequestParam("file") MultipartFile file) throws Exception {
		log.info("--------接收到了文件---------"+file.getOriginalFilename());
		RespUpload resp = new RespUpload()
				.setMd5(SecureUtil.md5(file.getInputStream()))
				.setUrl(cosUtil.upload(file))
				.setFileSize(file.getSize());
		return ResultResponseEnum.UPLOAD_SUCCESS.resultResponse(resp);
	}
	
	/**
	 * @throws Exception 
	 * @Description: 文件上传
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	@ApiPermission(AUTH.OPEN)
	@ApiOperLog(action = ACTION.UPLOAD)
	@ApiOperation(value = "上传文件")
	@PostMapping(value = "uploadFile", headers = "content-type=multipart/form-data")
	public ResultResponse<String> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
		return ResultResponseEnum.UPLOAD_SUCCESS.resultResponse(cosUtil.upload(file));
	}

	/**
	 * @Description: 文件上传
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/27
	 */
	@ApiOperLog(action = ACTION.UPLOAD, desc = "上传产品获取详情")
	@ApiOperation(value = "上传文件-上传产品获取详情")
	@PostMapping(value = "uploadApp", headers = "content-type=multipart/form-data")
	public ResultResponse<RespUpload> uploadApp(@RequestParam("file") MultipartFile file) throws Exception {
		String key = StrUtil.concat(true, "apps/",file.getOriginalFilename());
		RespUpload resp = new RespUpload()
				.setMd5(SecureUtil.md5(file.getInputStream()))
				.setUrl(cosUtil.upload(key,file))
				.setFileSize(file.getSize());
		return ResultResponseEnum.UPLOAD_SUCCESS.resultResponse(resp);
	}
	
	
	/**
	 * @Description: 文件上传-商店应用
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/26
	 */
	@ApiOperLog(action = ACTION.UPLOAD, desc = "上传商店应用获取详情")
	@ApiOperation(value = "上传文件-上传商店应用获取详情")
	@PostMapping(value = "uploadStoreApp", headers = "content-type=multipart/form-data")
	public ResultResponse<RespUpload> uploadStoreApp(@RequestParam("file") MultipartFile file) throws Exception {
		String key = StrUtil.concat(true, "storeApps/",IdUtil.fastSimpleUUID(),".",FileUtil.extName(file.getOriginalFilename()));
		RespUpload resp = new RespUpload()
				.setMd5(SecureUtil.md5(file.getInputStream()))
				.setUrl(cosUtil.upload(key,file))
				.setFileSize(file.getSize());
		return ResultResponseEnum.UPLOAD_SUCCESS.resultResponse(resp);
	}
	
	/**
	 * @throws Exception 
	 * @Description: 文件上传-产品
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/8/27
	 */
	@ApiOperLog(action = ACTION.UPLOAD, desc = "产品")
	@ApiOperation(value = "文件上传-产品")
	@PostMapping(value = "uploadBusinessApp", headers = "content-type=multipart/form-data")
	public ResultResponse<String> uploadBusinessApp(@RequestParam("file") MultipartFile file) throws Exception {
		String key = StrUtil.concat(true, "businessApps/",file.getOriginalFilename());
		return ResultResponseEnum.UPLOAD_SUCCESS.resultResponse(cosUtil.upload(key,file));
	}
	
	@ApiModel("响应-文件信息")
	@Accessors(chain = true)
	@Data
	public static class RespUpload implements Serializable {
		private static final long serialVersionUID = 1459584386888431788L;
		@ApiModelProperty(value = "访问地址")
		private String url;
		@ApiModelProperty(value = "MD5值")
		private String md5;
		@ApiModelProperty(value = "文件大小(b)")
		private Long fileSize;
	}

}
