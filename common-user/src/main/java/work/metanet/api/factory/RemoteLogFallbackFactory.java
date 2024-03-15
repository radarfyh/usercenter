package work.metanet.api.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import work.metanet.domain.R;
import work.metanet.api.RemoteLogService;
import work.metanet.api.domain.UcSecLogininfor;
import work.metanet.api.domain.UcSecOperLog;

/**
 * 日志服务降级处理
 * 
 * @author ruoyi
 */
@Component
public class RemoteLogFallbackFactory 
{
    private static final Logger log = LoggerFactory.getLogger(RemoteLogFallbackFactory.class);


    public RemoteLogService create(Throwable throwable)
    {
        log.error("日志服务调用失败:{}", throwable.getMessage());
        return new RemoteLogService()
        {
            @Override
            public R<Boolean> saveLog(UcSecOperLog sysOperLog, String source)
            {
                return null;
            }

            @Override
            public R<Boolean> saveLogininfor(UcSecLogininfor sysLogininfor, String source)
            {
                return null;
            }
        };

    }
}
