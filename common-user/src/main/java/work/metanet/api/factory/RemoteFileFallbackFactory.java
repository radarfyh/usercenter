package work.metanet.api.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import work.metanet.domain.R;
import work.metanet.api.RemoteFileService;
import work.metanet.api.domain.UcSecFile;

/**
 * 文件服务降级处理
 * 
 * @author ruoyi
 */
@Component
public class RemoteFileFallbackFactory 
{
    private static final Logger log = LoggerFactory.getLogger(RemoteFileFallbackFactory.class);

    public RemoteFileService create(Throwable throwable)
    {
        log.error("文件服务调用失败:{}", throwable.getMessage());
        return new RemoteFileService()
        {
            @Override
            public R<UcSecFile> upload(String file)
            {
                return R.fail("上传文件失败:" + throwable.getMessage());
            }
        };
    }
}
