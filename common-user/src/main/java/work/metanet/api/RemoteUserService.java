package work.metanet.api;

import work.metanet.constant.SecurityConstants;
import work.metanet.constant.ServiceNameConstants;
import work.metanet.domain.R;
import work.metanet.api.domain.UcSecUser;
import work.metanet.api.factory.RemoteUserFallbackFactory;
import work.metanet.api.model.LoginUser;

/**
 * 用户服务
 * 
 * @author ruoyi
 */
public interface RemoteUserService
{
    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @param source 请求来源
     * @return 结果
     */
    public R<LoginUser> getUserInfo(String username, String source);

    /**
     * 注册用户信息
     *
     * @param sysUser 用户信息
     * @param source 请求来源
     * @return 结果
     */
    public R<Boolean> registerUserInfo(UcSecUser sysUser, String source);
}
