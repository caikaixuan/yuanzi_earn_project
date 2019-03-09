package com.ygbc.brain.base.rpc;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Req<T> implements Serializable {

    private static final long serialVersionUID = -4315915986636858190L;

    /**
     * 登录名称
     */
    //@NotBlank(message = "登录名称不能为空")
    private String loginName;

    /**
     * 会话ID
     */
    //@NotBlank(message = "Session ID不能为空")
    private String sessionId;

    /**
     * 是否是暂存交易
     */
    private boolean isPending = false;

    /**
     * 暂存链接
     */
    private String pendingFrom;

    /**
     * 暂存编号
     */
    private String pendingCode;

    /**
     * 请求数据
     */
    @Valid
    @NotNull(message = "请求内容不能为空")
    private T data;

    /**
     * 界面快照
     */
    private String displayBuffer;

    /**
     * 页码(当前页)
     */
    private Integer pageNo;

    /**
     * 分页大小(每页数量)
     */
    private Integer pageSize;

    /**
     * 排序字段
     */
    private Integer sortField;

    /**
     * 排序方式,1.升序,2.降序
     */
    private Integer sortType;

    public Req() {
    }

    public Req(String loginName, String sessionId, T data) {
        this.loginName = loginName;
        this.sessionId = sessionId;
        this.data = data;
    }

    public Req(String loginName, String sessionId) {
        this.loginName = loginName;
        this.sessionId = sessionId;
    }

    public boolean isPending() {
        return isPending;
    }

    public void setPending(boolean pending) {
        isPending = pending;
    }

    public String getPendingCode() {
        return pendingCode;
    }

    public void setPendingCode(String pendingCode) {
        this.pendingCode = pendingCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getDisplayBuffer() {
        return displayBuffer;
    }

    public void setDisplayBuffer(String displayBuffer) {
        this.displayBuffer = displayBuffer;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getSortField() {
        return sortField;
    }

    public void setSortField(Integer sortField) {
        this.sortField = sortField;
    }

    public Integer getSortType() {
        return sortType;
    }

    public void setSortType(Integer sortType) {
        this.sortType = sortType;
    }

    public String getPendingFrom() {
        return pendingFrom;
    }

    public void setPendingFrom(String pendingFrom) {
        this.pendingFrom = pendingFrom;
    }
}
