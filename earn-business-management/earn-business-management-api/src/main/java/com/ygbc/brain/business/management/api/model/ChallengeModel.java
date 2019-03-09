package com.ygbc.brain.business.management.api.model;

import com.ygbc.brain.base.model.BaseModel;

import java.util.List;

public class ChallengeModel extends BaseModel {

    private List<QuestionModel> questionModels;

    private Long createRecordId;

    public ChallengeModel(List<QuestionModel> questionModels, Long createRecordId) {
        super();
        this.questionModels = questionModels;
        this.createRecordId = createRecordId;
    }

    public List<QuestionModel> getQuestionModels() {
        return questionModels;
    }

    public void setQuestionModels(List<QuestionModel> questionModels) {
        this.questionModels = questionModels;
    }

    public Long getCreateRecordId() {
        return createRecordId;
    }

    public void setCreateRecordId(Long createRecordId) {
        this.createRecordId = createRecordId;
    }
}
