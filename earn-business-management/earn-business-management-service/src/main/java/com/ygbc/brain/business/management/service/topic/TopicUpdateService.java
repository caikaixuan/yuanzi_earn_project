package com.ygbc.brain.business.management.service.topic;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.topic.UpdateTopicReqDTO;
import com.ygbc.brain.business.management.api.model.TopicModel;
import com.ygbc.brain.business.common.dal.data.TopicData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class TopicUpdateService extends BaseExecutableService<Req<UpdateTopicReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Resp execute(@Valid Req<UpdateTopicReqDTO> req) throws Exception {
        UpdateTopicReqDTO reqDTO = req.getData();
        TopicData topicData= Platform.sdbRead(TopicData.class,reqDTO.getTopicId());
        if(topicData == null){
            return Resp.build(TopicModel.class, Constants.PARAM_RESULTBLANK_CODE,Constants.PARAM_RESULTBLANK_DESC);
        }else{
            DeepBeanUtils.copyNotNullProperties(reqDTO,topicData);
            Platform.sdbUpdate(topicData);
            return Resp.build();
        }
    }
}
