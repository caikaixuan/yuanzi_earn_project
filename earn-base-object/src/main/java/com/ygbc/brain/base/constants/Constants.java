package com.ygbc.brain.base.constants;

/**
 *
 */
public class Constants {

    public static final String SUCCESS_RESP_CODE = "0000";
    public static final String SUCCESS_RESP_DESC = "成功";

    public static final String FAIL_RESP_CODE = "9999";
    public static final String FAIL_RESP_DESC = "处理失败";

    public final static String INVALID_TOKEN_ERROR_CODE = "9001";
    public final static String INVALID_TOKEN_ERROR_MSG = "无效的请求token";

    public static final String PARAM_NOBLANK_CODE = "9002";
    public static final String PARAM_NOBLANK_DESC = "必填参数不能为空";

    public static final String RECORD_IS_LOCKED_CODE = "9003";
    public static final String RECORD_IS_LOCKED_DESC = "更新记录已被锁定，请稍后再试";

    public static final String PARAM_VALIDATE_ERROR_CODE = "9004";
    public static final String PARAM_VALIDATE_ERROR_DESC = "参数校验未通过";

    public static final String PARAM_RESULTBLANK_CODE = "9005";
    public static final String PARAM_RESULTBLANK_DESC = "查询结果为空";

    public final static String BUSINESS_ERROR_CODE = "9100";
    public final static String BUSINESS_ERROR_MSG = "业务异常";

    public final static String POOL_STATUS_VALIDATE_CODE = "9200";
    public final static String POOL_STATUS_VALIDATE_DESC ="奖池被锁定或已结算，无法参与";

    public static final int CHALLENGE_SIZE = 10;
    public static final int CHALLENGE_PAGE_NUMBER = 1;



}
