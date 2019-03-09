package com.ygbc.brain.common.exception;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Resp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 功能: 异常处理类
 * 创建: liuchongguang - liuchongguang@zillionfortune.com
 * 日期: 2017/2/9 0009 09:29
 * 版本: V1.0
 */
@Component
public class ExceptionHandler {

    /**
     * 异常处理
     *
     * @param e
     * @return
     */
    public Resp handleException(Exception e) {
        if (e instanceof BusinessException) {
            BusinessException be = (BusinessException) e;
            return Resp.build(be.getResultCode(), be.getResultMsg());
        } else if (e instanceof ValidateException) {
            ValidateException ve = (ValidateException) e;
            return Resp.build(ve.getResultCode(), ve.getResultMsg());
        } else {
            return Resp.build(Constants.FAIL_RESP_CODE, Constants.FAIL_RESP_DESC, e.toString());
        }
    }

    /**
     * 异常处理
     *
     * @param e
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> Resp<T> handleException(Exception e, Class clazz) {
        if (e instanceof BusinessException) {
            BusinessException be = (BusinessException) e;
            return Resp.build(clazz, StringUtils.isBlank(be.getResultCode()) ? Constants.FAIL_RESP_CODE : be.getResultCode(), be.getResultMsg(),
                    be.getException() != null ? be.getException().toString() : "");
        } else if (e instanceof ValidateException) {
            ValidateException ve = (ValidateException) e;
            return Resp.build(clazz, StringUtils.isBlank(ve.getResultCode()) ? Constants.FAIL_RESP_CODE : ve.getResultCode(), ve.getResultMsg(),
                    ve.getException() != null ? ve.getException().toString() : "");
        } else {
            return Resp.build(clazz, Constants.FAIL_RESP_CODE, Constants.FAIL_RESP_DESC, e.toString());
        }
    }
}
