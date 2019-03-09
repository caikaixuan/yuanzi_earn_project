package com.ygbc.brain.business.management.api.model;

import com.alibaba.fastjson.JSONObject;
import com.ygbc.brain.base.model.BaseModel;

public class QuestionModel extends BaseModel {
    /**
    * 题目编号
    */
    private Long questionId;

    /** 
    * 题目内容
    */
    private String content;

    /** 
    * 题目选项
    */
    private JSONObject options;

    /** 
    * 答案
    */
    private String answer;

    /** 
    * 答案解析
    */
    private String parsing;

    /** 
    * 话题编号
    */
    private Long topicId;

    /** 
    * 题目类型
    */
    private Integer type;

    /** 
    * 题目难度值
    */
    private Integer difficulty;

    /** 
    * 答对率 0：选择题；1：判断题；2：问答题
    */
    private Integer currentRate;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public JSONObject getOptions() {
        return options;
    }

    public void setOptions(JSONObject options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getParsing() {
        return parsing;
    }

    public void setParsing(String parsing) {
        this.parsing = parsing == null ? null : parsing.trim();
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(Integer currentRate) {
        this.currentRate = currentRate;
    }

}