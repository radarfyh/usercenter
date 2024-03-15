package work.metanet.api;

import work.metanet.domain.R;
import work.metanet.api.domain.UcSecFile;

/**
 * 文件服务
 * 
 * @author ruoyi
 */
public interface RemoteFileService
{
    /**
     * 上传文件
     *
     * @param file 文件信息
     * @return 结果
     */
    public R<UcSecFile> upload(String file);
}
