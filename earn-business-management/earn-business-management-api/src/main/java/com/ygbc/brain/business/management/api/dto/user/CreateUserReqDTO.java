package com.ygbc.brain.business.management.api.dto.user;

import com.ygbc.brain.base.dto.BaseDTO;

import java.math.BigDecimal;
import java.util.Date;

public class CreateUserReqDTO extends BaseDTO {
    /**
     * 用户密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickName;

    /**
     * 手机号码
     */
    private String telphone;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * qq号
     */
    private String qq;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 个人签名
     */
    private String signSaying;

    /**
     * 头像图片路径
     */
    private String headSculptureImageUrl;

    /**
     * 计划挑战成功概率
     */
    private Integer planRate;

    /**
     * 当前概率
     */
    private Integer currentRate;

    /**
     * 擅长话题编号
     */
    private Long goodAt;

    /**
     * 兴趣话题编号
     */
    private Long interestIn;

    /**
     * 是否有权邀请
     */
    private Boolean canInvite;

    /**
     * 邀请码
     */
    private String inviteCode;

    /**
     * 邀请朋友数量限制
     */
    private Integer inviteFriendNumLimit;

    /**
     * 邀请朋友数量
     */
    private Integer invitedFriendNum;

    /**
     * 是否受邀而来
     */
    private Boolean isInvited;

    /**
     * 介绍人编号
     */
    private Long invitorUserId;

    /**
     * 是否机器人
     */
    private Boolean isRobot;

    /**
     * 积分余额
     */
    private Integer integration;

    /**
     * 上次提现时间
     */
    private Date lastWithdraw;

    /**
     * 是否有权提现
     */
    private Boolean canWithdraw;

    /**
     * 提现总金额
     */
    private BigDecimal withdraw;

    /**
     * 积分盈利
     */
    private Integer gain;

    /**
     * 上周盈利
     */
    private Integer lastWeekGain;

    /**
     * 充值总金额
     */
    private BigDecimal charge;

    /**
     * 上次登录时间
     */
    private Date lastLoginTime;

    /**
     * 等级 1：最高级；2：次之；3：次次之
     */
    private Integer rank;

    private Integer challengeNum;

    private Integer successNum;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSignSaying() {
        return signSaying;
    }

    public void setSignSaying(String signSaying) {
        this.signSaying = signSaying == null ? null : signSaying.trim();
    }

    public String getHeadSculptureImageUrl() {
        return headSculptureImageUrl;
    }

    public void setHeadSculptureImageUrl(String headSculptureImageUrl) {
        this.headSculptureImageUrl = headSculptureImageUrl == null ? null : headSculptureImageUrl.trim();
    }

    public Integer getPlanRate() {
        return planRate;
    }

    public void setPlanRate(Integer planRate) {
        this.planRate = planRate;
    }

    public Integer getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(Integer currentRate) {
        this.currentRate = currentRate;
    }

    public Long getGoodAt() {
        return goodAt;
    }

    public void setGoodAt(Long goodAt) {
        this.goodAt = goodAt;
    }

    public Long getInterestIn() {
        return interestIn;
    }

    public void setInterestIn(Long interestIn) {
        this.interestIn = interestIn;
    }

    public Boolean getCanInvite() {
        return canInvite;
    }

    public void setCanInvite(Boolean canInvite) {
        this.canInvite = canInvite;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode == null ? null : inviteCode.trim();
    }

    public Integer getInviteFriendNumLimit() {
        return inviteFriendNumLimit;
    }

    public void setInviteFriendNumLimit(Integer inviteFriendNumLimit) {
        this.inviteFriendNumLimit = inviteFriendNumLimit;
    }

    public Integer getInvitedFriendNum() {
        return invitedFriendNum;
    }

    public void setInvitedFriendNum(Integer invitedFriendNum) {
        this.invitedFriendNum = invitedFriendNum;
    }

    public Boolean getIsInvited() {
        return isInvited;
    }

    public void setIsInvited(Boolean isInvited) {
        this.isInvited = isInvited;
    }

    public Long getInvitorUserId() {
        return invitorUserId;
    }

    public void setInvitorUserId(Long invitorUserId) {
        this.invitorUserId = invitorUserId;
    }

    public Boolean getIsRobot() {
        return isRobot;
    }

    public void setIsRobot(Boolean isRobot) {
        this.isRobot = isRobot;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public Date getLastWithdraw() {
        return lastWithdraw;
    }

    public void setLastWithdraw(Date lastWithdraw) {
        this.lastWithdraw = lastWithdraw;
    }

    public Boolean getCanWithdraw() {
        return canWithdraw;
    }

    public void setCanWithdraw(Boolean canWithdraw) {
        this.canWithdraw = canWithdraw;
    }

    public BigDecimal getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(BigDecimal withdraw) {
        this.withdraw = withdraw;
    }

    public Integer getGain() {
        return gain;
    }

    public void setGain(Integer gain) {
        this.gain = gain;
    }

    public Integer getLastWeekGain() {
        return lastWeekGain;
    }

    public void setLastWeekGain(Integer lastWeekGain) {
        this.lastWeekGain = lastWeekGain;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getChallengeNum() {
        return challengeNum;
    }

    public void setChallengeNum(Integer challengeNum) {
        this.challengeNum = challengeNum;
    }

    public Integer getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(Integer successNum) {
        this.successNum = successNum;
    }

}
