package com.ygbc.brain.business.management.service.topic;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.topic.QueryTopicListReqDTO;
import com.ygbc.brain.business.management.api.model.TopicModel;
import com.ygbc.brain.business.common.dal.data.TopicData;
import com.ygbc.brain.common.model.Page;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class TopicListService extends BaseExecutableService<Req<QueryTopicListReqDTO>,Resp<List<TopicModel>>>{
    @Override
    public Resp<List<TopicModel>> execute(@Valid Req<QueryTopicListReqDTO> req) throws Exception {
        Page page = new Page(req.getPageNo(), req.getPageSize());
        TopicData topicData = DeepBeanUtils.copyAs(req.getData(), TopicData.class);
        int total = Platform.dbCount(topicData);
        List<TopicModel> topicModelList = null;
        if (total > 0) {
            List<TopicData> topicDataList = Platform.dbReadSet(topicData, page, req.getSortField(), req.getSortType());
            topicModelList = DeepBeanUtils.copyAs(topicDataList, TopicModel.class);
        }
        return Resp.build(page.getPageNo(), page.getPageSize(), total, topicModelList);
    }
}
