package work.metanet.api;


import work.metanet.domain.R;
import work.metanet.api.domain.UcSecLogininfor;
import work.metanet.api.domain.UcSecOperLog;


/**
 * 日志服务
 * 
 * @author ruoyi
 */
public interface RemoteLogService
{
    /**
     * 保存系统日志
     *
     * @param sysOperLog 日志实体
     * @param source 请求来源
     * @return 结果
     */
    public R<Boolean> saveLog( UcSecOperLog sysOperLog, String source);

    /**
     * 保存访问记录
     *
     * @param sysLogininfor 访问实体
     * @param source 请求来源
     * @return 结果
     */
    public R<Boolean> saveLogininfor(UcSecLogininfor sysLogininfor, String source);
}
