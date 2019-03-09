package com.ygbc.brain.business.management.service.topic;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.topic.QueryTopicDetailReqDTO;
import com.ygbc.brain.business.management.api.model.TopicModel;
import com.ygbc.brain.business.common.dal.data.TopicData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class TopicDetailService extends BaseExecutableService<Req<QueryTopicDetailReqDTO>,Resp<TopicModel>>{
    @Override
    public Resp<TopicModel> execute(@Valid Req<QueryTopicDetailReqDTO> req) throws Exception {
        TopicData topicData = Platform.sdbRead(TopicData.class,req.getData().getTopicId());
        if (topicData == null) {
            return Resp.build(TopicModel.class, Constants.PARAM_RESULTBLANK_CODE, Constants.PARAM_RESULTBLANK_DESC);
        } else {
            return Resp.build(DeepBeanUtils.copyAs(topicData, TopicModel.class));
        }
    }
}
