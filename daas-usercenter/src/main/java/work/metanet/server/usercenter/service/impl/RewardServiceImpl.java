package work.metanet.server.usercenter.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import work.metanet.server.usercenter.repository.FmRewardRepository;
import work.metanet.server.usercenter.service.RewardService;
import work.metanet.base.page.MyPageRequest;
import work.metanet.base.page.MyPageResult;
import work.metanet.exception.MetanetException;
import work.metanet.server.usercenter.domain.UcRewards;

import cn.hutool.core.bean.BeanUtil;

@DubboService
@RefreshScope
public class RewardServiceImpl implements RewardService {
	
	@Autowired
	private FmRewardRepository rewardRepository;
	
	/**
	 * @Description: 新增奖励-奖励后期需要根据指定资源奖励
	 * @Author Louis & Edison & W.B.
	 * @DateTime 2021/07/16
	 */
	@Override
	public void addReward(UcRewards req) throws Exception {
		if(rewardRepository.existsReward(req)) throw MetanetException.of().setMsg("请勿重复奖励");
		UcRewards reward = new UcRewards();
		BeanUtil.copyProperties(req, reward);
		rewardRepository.save(reward);
	}

	@Override
	public int save(UcRewards record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(UcRewards record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String id, UcRewards record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UcRewards record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UcRewards record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(List<UcRewards> records) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UcRewards findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyPageResult findPage(MyPageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UcRewards> findAllSort(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UcRewards> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
