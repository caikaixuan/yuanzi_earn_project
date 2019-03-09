package com.ygbc.brain.common.aspect;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.common.aspect.validate.FieldValidator;
import com.ygbc.brain.common.utils.SpringUtils;
import com.ygbc.brain.common.validate.BaseValidator;
import com.ygbc.brain.common.validate.annotation.Validator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.validation.Valid;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能: 字段基础校验切面
 * 创建: liuchongguang - liuchongguang@zillionfortune.com
 * 日期: 2017/2/10 0010 09:31
 * 版本: V1.0
 */
public class FieldValidateAspect {

    @Autowired
    private FieldValidator fieldValidator;

    /**
     * 参数校验切面处理
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //获取当前执行方法
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        //获取需要校验的参数数组
        List<Object> args = getMethodValidateParams(method, pjp.getArgs());
        Map<String, String> errors = new HashMap<>();
        //如果有需要校验的参数
        if (!CollectionUtils.isEmpty(args)) {
            for (Object arg : args) {
                Map<String, String> map = fieldValidator.validateFieldErrors(arg);
                if (!CollectionUtils.isEmpty(map)) {
                    errors.putAll(map);
                }
            }
        }
        Validator validator = method.getAnnotation(Validator.class);
        if (validator != null) {
            BaseValidator validatorInstance = SpringUtils.getBean(validator.className());
            Object[] params = pjp.getArgs();
            for (Object arg : params) {
                if (arg instanceof Req) {
                    Req req = (Req) arg;
                    Map<String, String> map = validatorInstance.validate(errors, req.getData(), validator.includes(), validator.excludes());
                    if (!CollectionUtils.isEmpty(map)) {
                        errors.putAll(map);
                    }
                }
            }
        }
        if (!CollectionUtils.isEmpty(errors)) {
            return Resp.build(Constants.PARAM_VALIDATE_ERROR_CODE, Constants.PARAM_VALIDATE_ERROR_DESC, errors);
        }
        return pjp.proceed();
    }

    private List<Object> getMethodValidateParams(Method method, Object[] args) {
        List<Object> params = new ArrayList<>();
        Annotation[][] annotationsArray = method.getParameterAnnotations();
        for (int i = 0; i < annotationsArray.length; i++) {
            Annotation[] annotations = annotationsArray[i];
            for (int j = 0; j < annotations.length; j++) {
                if (annotations[j] instanceof Valid) {
                    params.add(args[i]);
                }
            }
        }
        return params;
    }

}
