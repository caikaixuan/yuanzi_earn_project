package com.ygbc.brain.business.common.entity;

import com.ygbc.brain.business.common.dal.data.UserData;

import java.math.BigDecimal;
import java.util.Date;

public class User extends AttributeEntity<User,UserData> {

    public User(){

    }

    public User(UserData data){
        super(data);
    }

    public Long getUserId() {
        return this.data.getUserId();
    }

    public void setUserId(Long userId) {
        this.data.setUserId(userId);
    }

    public String getPassword() {
        return this.data.getPassword();
    }

    public void setPassword(String password) {
        this.data.setPassword(password);
    }

    public String getNickName() {
        return this.data.getNickName();
    }

    public void setNickName(String nickName) {
        this.data.setNickName(nickName);
    }

    public String getTelphone() {
        return this.data.getTelphone();
    }

    public void setTelphone(String telphone) {
        this.data.setTelphone(telphone);
    }

    public String getWechat() {
        return this.data.getWechat();
    }

    public void setWechat(String wechat) {
        this.data.setWechat(wechat);
    }

    public String getQq() {
        return this.data.getQq();
    }

    public void setQq(String qq) {
        this.data.setQq(qq);
    }

    public String getEmail() {
        return this.data.getEmail();
    }

    public void setEmail(String email) {
        this.data.setEmail(email);
    }

    public String getSignSaying() {
        return this.data.getSignSaying();
    }

    public void setSignSaying(String signSaying) {
        this.data.setSignSaying(signSaying);
    }

    public String getHeadSculptureImageUrl() {
        return this.data.getHeadSculptureImageUrl();
    }

    public void setHeadSculptureImageUrl(String headSculptureImageUrl) {
        this.data.setHeadSculptureImageUrl(headSculptureImageUrl);
    }

    public Integer getPlanRate() {
        return this.data.getPlanRate();
    }

    public void setPlanRate(Integer planRate) {
        this.data.setPlanRate(planRate);
    }

    public Integer getCurrentRate() {
        return this.data.getCurrentRate();
    }

    public void setCurrentRate(Integer currentRate) {
        this.data.setCurrentRate(currentRate);
    }

    public Long getGoodAt() {
        return this.data.getGoodAt();
    }

    public void setGoodAt(Long goodAt) {
        this.data.setGoodAt(goodAt);
    }

    public Long getInterestIn() {
        return this.data.getInterestIn();
    }

    public void setInterestIn(Long IntegererestIn) {
        this.data.setInterestIn(IntegererestIn);
    }

    public Boolean getCanInvite() {
        return this.data.getCanInvite();
    }

    public void setCanInvite(Boolean canInvite) {
        this.data.setCanInvite(canInvite);
    }

    public String getInviteCode() {
        return this.data.getInviteCode();
    }

    public void setInviteCode(String inviteCode) {
        this.data.setInviteCode(inviteCode);
    }

    public Integer getInviteFriendNumLimit() {
        return this.data.getInviteFriendNumLimit();
    }

    public void setInviteFriendNumLimit(Integer inviteFriendNumLimit) {
        this.data.setInviteFriendNumLimit(inviteFriendNumLimit);
    }

    public Integer getInvitedFriendNum() {
        return this.data.getInvitedFriendNum();
    }

    public void setInvitedFriendNum(Integer invitedFriendNum) {
        this.data.setInvitedFriendNum(invitedFriendNum);
    }

    public Boolean getIsInvited() {
        return this.data.getIsInvited();
    }

    public void setIsInvited(Boolean isInvited) {
        this.data.setIsInvited(isInvited);
    }

    public Long getInvitorUserId() {
        return this.data.getInvitorUserId();
    }

    public void setInvitorUserId(Long invitorUserId) {
        this.data.setInvitorUserId(invitorUserId);
    }

    public Boolean getIsRobot() {
        return this.data.getIsRobot();
    }

    public void setIsRobot(Boolean isRobot) {
        this.data.setIsRobot(isRobot);
    }

    public Integer getIntegration() {
        return this.data.getIntegration();
    }

    public void setIntegration(Integer Integeregration) {
        this.data.setIntegration(Integeregration);
    }

    public Date getLastWithdraw() {
        return this.data.getLastWithdraw();
    }

    public void setLastWithdraw(Date lastWithdraw) {
        this.data.setLastWithdraw(lastWithdraw);
    }

    public Boolean getCanWithdraw() {
        return this.data.getCanWithdraw();
    }

    public void setCanWithdraw(Boolean canWithdraw) {
        this.data.setCanWithdraw(canWithdraw);
    }

    public BigDecimal getWithdraw() {
        return this.data.getWithdraw();
    }

    public void setWithdraw(BigDecimal withdraw) {
        this.data.setWithdraw(withdraw);
    }

    public Integer getGain() {
        return this.data.getGain();
    }

    public void setGain(Integer gain) {
        this.data.setGain(gain);
    }

    public Integer getLastWeekGain() {
        return this.data.getLastWeekGain();
    }

    public void setLastWeekGain(Integer lastWeekGain) {
        this.setLastWeekGain(lastWeekGain);
    }

    public BigDecimal getCharge() {
        return this.data.getCharge();
    }

    public void setCharge(BigDecimal charge) {
        this.setCharge(charge);
    }

    public Date getLastLoginTime() {
        return this.data.getLastLoginTime();
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.data.setLastLoginTime(lastLoginTime);
    }

    public Integer getRank() {
        return this.data.getRank();
    }

    public void setRank(Integer rank) {
        this.data.setRank(rank);
    }

    public Integer getChallengeNum() {
        return this.data.getChallengeNum();
    }

    public void setChallengeNum(Integer challengeNum) {
        this.data.setChallengeNum(challengeNum);
    }

    public Integer getSuccessNum() {
        return this.data.getSuccessNum();
    }

    public void setSuccessNum(Integer successNum) {
        this.data.setSuccessNum(successNum);
    }

    public String getStatus() {
        return this.data.getStatus();
    }

    public void setStatus(String status) {
        this.data.setStatus(status);
    }

}
