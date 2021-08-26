package work.metanet.server.service;


import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import work.metanet.api.channel.IChannelService;
import work.metanet.api.channel.protocol.ReqChannelInfo;
import work.metanet.api.channel.protocol.ReqChannelInfo.RespChannelInfo;
import work.metanet.api.channel.protocol.ReqChannelList;
import work.metanet.api.channel.protocol.ReqChannelList.RespChannelList;
import work.metanet.api.channel.protocol.ReqChannelLogin;
import work.metanet.api.channel.protocol.ReqChannelLogin.RespChannelLogin;
import work.metanet.api.channel.protocol.ReqRemoveChannel;
import work.metanet.api.channel.protocol.ReqSaveChannel;
import work.metanet.api.channel.protocol.ReqUpdChannelPassword;
import work.metanet.api.permission.vo.MenuVo;
import work.metanet.base.RespPaging;

import work.metanet.constant.ConstCacheKey;
import work.metanet.constant.Constant;
import work.metanet.exception.MetanetException;
import work.metanet.exception.ResultResponseEnum;
import work.metanet.model.Channel;
import work.metanet.server.dao.ChannelMapper;
import work.metanet.server.dao.SequenceMapper;
import work.metanet.util.menu.MenuUtil;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.extra.pinyin.PinyinUtil;

@DubboService
@Component
@RefreshScope
public class ChannelService implements IChannelService{

	@Autowired
	private ChannelMapper channelMapper;
	@Autowired
	private SequenceMapper sequenceMapper;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private Constant constant;
	
	/**
	 * @Description: 重置渠道密码
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2020/05/12
	 */
	@Override
	public void resetChannelPassword(String channelId) throws Exception {
		Channel channel = new Channel();
		channel.setChannelId(channelId);
		channel.setPassword(constant.getDefault_password());
		channelMapper.updateByPrimaryKeySelective(channel);
	}
	
	@Override
	public void cacheSession(String channelId, String sessionId) throws Exception {
		stringRedisTemplate.opsForValue().set(
				ConstCacheKey.SESSION.cacheKey(channelId), 
				sessionId,
				Duration.ofSeconds(ConstCacheKey.SESSION.getExpire())
				);
	}
	
	@Override
	public String cacheSession(String channelId) throws Exception {
		return stringRedisTemplate.opsForValue().get(ConstCacheKey.SESSION.cacheKey(channelId));
	}
	
	@Override
	public RespChannelLogin login(ReqChannelLogin req) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", req.getUsername());
		map.put("password", req.getPassword());
		Channel channel = channelMapper.getChannel(map);
		if(channel==null)
			throw MetanetException.of().setMsg("用户名或密码错误");
		
		RespChannelLogin resp = new RespChannelLogin();
		BeanUtil.copyProperties(channel, resp);

		return resp;
	}
	
	@Override
	public void updChannelPassword(String channelId, ReqUpdChannelPassword req) throws Exception {
		Channel channel = channelMapper.selectByPrimaryKey(channelId);
		if(!channel.getPassword().equals(SecureUtil.md5(req.getOldPassword())))
			throw MetanetException.of().setMsg("原密码错误");
		channel.setPassword(SecureUtil.md5(req.getNewPassword()));
		channelMapper.updateByPrimaryKeySelective(channel);
	}
	
	/**
	 * @Description: 渠道列表
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	@Override
	public RespPaging<RespChannelList> channelList(ReqChannelList req) throws Exception {
		RespPaging<RespChannelList> respPaging = new RespPaging<RespChannelList>();
		PageHelper.startPage(req.getPageNum(), req.getPageSize());
		List<RespChannelList> list = channelMapper.channelList(BeanUtil.beanToMap(req));
		BeanUtil.copyProperties(new PageInfo<RespChannelList>(list), respPaging);
		return respPaging;
	}

	/**
	 * @Description: 渠道信息
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	@Override
	public RespChannelInfo channelInfo(ReqChannelInfo req) throws Exception {
		RespChannelInfo resp = channelMapper.channelInfo(BeanUtil.beanToMap(req));
		return resp;
	}

	/**
	 * @Description: 保存渠道
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	@Override
	public void saveChannel(ReqSaveChannel req) throws Exception {
		Channel channel = new Channel();
		BeanUtil.copyProperties(req, channel);
		if(StrUtil.isBlank(channel.getUsername())) {
			channel.setUsername(PinyinUtil.getPinyin(channel.getChannelName(), ""));			
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("channelName", req.getChannelName());
		Channel dbChannel = channelMapper.getChannel(map);
		
		if(StringUtils.isNotBlank(channel.getChannelId())) {
			//修改操作
			if(!BeanUtil.isEmpty(dbChannel) && !dbChannel.getChannelId().equals(channel.getChannelId())) 
				throw MetanetException.of().setMsg("名称已存在");
			if(BeanUtil.isEmpty(dbChannel) || dbChannel.getChannelId().equals(channel.getChannelId())) {
				channel.setPassword(null);
				channelMapper.updateByPrimaryKeySelective(channel);
			}else {
				throw MetanetException.of().setResult(ResultResponseEnum.SERVER_FAILURE.resultResponse());			
			}
		}else {
			//新增操作
			if(!BeanUtil.isEmpty(dbChannel))
				throw MetanetException.of().setMsg("名称已存在");
			channel.setChannelId(sequenceMapper.generateChannelId());
			channel.setPassword(constant.getDefault_password());
			channelMapper.insertSelective(channel);
		}
	}

	/**
	 * @Description: 删除渠道
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2019/11/20
	 */
	@Override
	public void removeChannel(List<ReqRemoveChannel> req) throws Exception {
		channelMapper.removeChannel(req);
	}
}
