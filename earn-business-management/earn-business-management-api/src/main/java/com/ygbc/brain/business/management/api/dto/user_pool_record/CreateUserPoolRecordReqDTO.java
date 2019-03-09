package com.ygbc.brain.business.management.api.dto.user_pool_record;

import com.ygbc.brain.base.dto.BaseDTO;
import com.ygbc.brain.business.management.api.dto.answer_record.CreateAnswerRecordReqDTO;
import com.ygbc.brain.business.management.api.model.PoolModel;

import java.util.List;

public class CreateUserPoolRecordReqDTO extends BaseDTO {
    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 奖池编号
     */
    private Long poolId;

    /**
     * 用户昵称
     */
    private String userNickName;

    /**
     * 答对题数
     */
    private Integer rightNum;

    /**
     * 消费积分
     */
    private Integer consumeIntegration;

    /**
     * 挑战结果 0：挑战失败；1：挑战成功
     */
    private Boolean result;

    /**
     * 回答的问题列表
     */
    private List<CreateAnswerRecordReqDTO> answerRecords;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName == null ? null : userNickName.trim();
    }

    public Integer getRightNum() {
        return rightNum;
    }

    public void setRightNum(Integer rightNum) {
        this.rightNum = rightNum;
    }

    public Integer getConsumeIntegration() {
        return consumeIntegration;
    }

    public void setConsumeIntegration(Integer consumeIntegration) {
        this.consumeIntegration = consumeIntegration;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public List<CreateAnswerRecordReqDTO> getAnswerRecords() {
        return answerRecords;
    }

    public void setAnswerRecords(List<CreateAnswerRecordReqDTO> answerRecords) {
        this.answerRecords = answerRecords;
    }
}
