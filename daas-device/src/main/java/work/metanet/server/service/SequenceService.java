package work.metanet.server.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import work.metanet.api.sequence.ISequenceService;
import work.metanet.server.dao.SequenceMapper;

@DubboService
@RefreshScope
public class SequenceService implements ISequenceService{

	@Autowired
	private SequenceMapper sequenceMapper;
	
	@Override
	public String generateOrderId() {
		return sequenceMapper.generateOrderId();
	}
	
}
