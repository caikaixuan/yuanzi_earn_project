package com.ygbc.brain.common.model;

import org.apache.ibatis.session.RowBounds;

import java.io.Serializable;

/**
 * Created by wangwanbin on 2017/1/9.
 */
public class Page extends RowBounds implements Serializable {

    /**
     * SerialVersionUID
     */
    private static final long serialVersionUID = -6819447916936272653L;

    private Integer pageNo = 1;

    private Integer pageSize = 10;

    public Page() {
    }

    public Page(Integer pageNo, Integer pageSize) {
        if (pageNo != null && pageSize != null) {
            this.pageNo = pageNo;
            this.pageSize = pageSize;
        }
    }

    public static Page getNullPage() {
        Page page = new Page();
        page.setPageNo(null);
        page.setPageSize(null);
        return page;
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

    /**
     * 偏移量,用于sql分页查询(从0开始)
     */
    public int getOffset() {
        if (pageNo != null && pageSize != null) {
            return ((pageNo - 1) * pageSize);
        } else {
            return 0;
        }
    }

    public int getLimit() {
        if (pageSize != null) {
            return pageSize;
        } else {
            return Integer.MAX_VALUE;
        }
    }
}
