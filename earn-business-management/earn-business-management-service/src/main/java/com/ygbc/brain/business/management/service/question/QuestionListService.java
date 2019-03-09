package com.ygbc.brain.business.management.service.question;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.question.QueryQuestionListReqDTO;
import com.ygbc.brain.business.management.api.model.QuestionModel;
import com.ygbc.brain.business.common.dal.data.QuestionData;
import com.ygbc.brain.common.model.Page;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class QuestionListService extends BaseExecutableService<Req<QueryQuestionListReqDTO>,Resp<List<QuestionModel>>>{
    @Override
    public Resp<List<QuestionModel>> execute(@Valid Req<QueryQuestionListReqDTO> req) throws Exception {
        Page page = new Page(req.getPageNo(), req.getPageSize());
        QuestionData questionData = DeepBeanUtils.copyAs(req.getData(), QuestionData.class);
        int total = Platform.dbCount(questionData);
        List<QuestionModel> questionModelList = null;
        if (total > 0) {
            List<QuestionData> questionDataList = Platform.dbReadSet(questionData, page, req.getSortField(), req.getSortType());
            questionModelList = DeepBeanUtils.copyAs(questionDataList, QuestionModel.class);
        }
        return Resp.build(page.getPageNo(), page.getPageSize(), total, questionModelList);
    }
}
