package com.ygbc.brain.business.management.service.topic;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.topic.DeleteTopicReqDTO;
import com.ygbc.brain.business.management.api.model.TopicModel;
import com.ygbc.brain.business.common.dal.data.TopicData;
import com.ygbc.brain.common.enums.TrueFalse;
import com.ygbc.brain.common.enums.YesNo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class TopicDeleteService extends BaseExecutableService<Req<DeleteTopicReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
//    @Validator(className = DeleteTopicValidator.class)
    public Resp execute(@Valid Req<DeleteTopicReqDTO> req) throws Exception {
        TopicData topicData = Platform.sdbRead(TopicData.class,req.getData().getTopicId());
        if(topicData == null){
            return Resp.build(TopicModel.class, Constants.PARAM_RESULTBLANK_CODE,Constants.PARAM_RESULTBLANK_DESC);
        }else{
            topicData.setIsDel(TrueFalse.TRUE.getValue());
            Platform.sdbUpdate(topicData);
            return Resp.build();
        }
    }
}
