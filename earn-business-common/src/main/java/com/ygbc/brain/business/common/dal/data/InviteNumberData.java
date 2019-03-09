package com.ygbc.brain.business.common.dal.data;


public class InviteNumberData extends BaseData {
    /**
    * 邀请码编号
    */
    private Long inviteNumberId;

    /** 
    * 用户编号
    */
    private Long userId;

    /** 
    * 邀请码
    */
    private String number;

    /** 
    * 邀请人数限制
    */
    private Integer inviteFriendNumLimit;

    /** 
    * 已邀请人数
    */
    private Integer invitedFriendNum;

    /** 
    * 状态 F:冻结禁用；A:活跃
    */
    private String status;

    public Long getInviteNumberId() {
        return inviteNumberId;
    }

    public void setInviteNumberId(Long inviteNumberId) {
        this.inviteNumberId = inviteNumberId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

}