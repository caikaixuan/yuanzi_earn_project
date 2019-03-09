package com.ygbc.brain.business.management.service.topic;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.dal.data.TopicData;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.topic.CreateTopicReqDTO;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import com.ygbc.brain.common.utils.IdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class TopicCreateService extends BaseExecutableService<Req<CreateTopicReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Resp execute(@Valid Req<CreateTopicReqDTO> req) throws Exception {
        CreateTopicReqDTO reqDTO = req.getData();
        TopicData topicData = DeepBeanUtils.copyAs(reqDTO,TopicData.class);
        if(topicData != null){
            topicData.setTopicId(IdWorker.getFlowIdWorkerInstance().nextId());
            Platform.sdbInsert(topicData);
        }
        return Resp.build();
    }
}
