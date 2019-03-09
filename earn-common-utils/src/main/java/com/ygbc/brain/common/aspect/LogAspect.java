package com.ygbc.brain.common.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.common.exception.ValidateException;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by wangwanbin on 2017/1/3.
 * 使用springAop打印请求参数和返回参数及异常信息
 */
public class LogAspect {

    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 是否打印display日志
     */
    private boolean isPrintDisplayBuffer = false;

    //任何通知方法都可以将第一个参数定义为 org.aspectj.lang.JoinPoint类型
    public void before(JoinPoint call) {
        //获取目标对象对应的类名
        String className = call.getTarget().getClass().getName();
        //获取目标对象上正在执行的方法名
        String methodName = call.getSignature().getName();
        logger.info(className + "." + methodName + "开始执行");
        //获取参数
        Object[] args = call.getArgs();
        //拼接字符串,打印请求参数
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            sb.append("请求参数" + (i + 1) + ":");
            if (!this.isPrintDisplayBuffer) {
                if (args[i] instanceof Req) {
                    JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(args[i], SerializerFeature.WriteDateUseDateFormat));
                    if (jsonObject.containsKey("displayBuffer")) {
                        jsonObject.remove("displayBuffer");
                    }
                    sb.append(jsonObject.toString());
                }
            } else {
                sb.append(JSON.toJSONString(args[i], SerializerFeature.WriteDateUseDateFormat));
            }
        }
        logger.info(sb.toString());
    }

    public void afterReturn(JoinPoint call, Object retValue) {
        //获取目标对象对应的类名
        String className = call.getTarget().getClass().getName();
        //获取目标对象上正在执行的方法名
        String methodName = call.getSignature().getName();
        StringBuilder sb = new StringBuilder();
        sb.append(className).append(".").append(methodName);
        sb.append("返回值:");
        //sb.append(JsonUtils.getArgsString(retValue));
        sb.append(JSON.toJSONString(retValue, SerializerFeature.WriteDateUseDateFormat));
        logger.info(sb.toString());
    }

    public void afterThrowing(JoinPoint call, Throwable ex) {
        //获取目标对象对应的类名
        String className = call.getTarget().getClass().getName();
        //获取目标对象上正在执行的方法名
        String methodName = call.getSignature().getName();
        if (ex instanceof ValidateException) {
            ValidateException ve = (ValidateException) ex;
            logger.error(className + "." + methodName + "参数校验不通过:" + ve.getResultMsg());
        } else {
            logger.error(className + "." + methodName + "发生异常:", ex);
        }
    }

    public boolean isPrintDisplayBuffer() {
        return isPrintDisplayBuffer;
    }

    public void setPrintDisplayBuffer(boolean printDisplayBuffer) {
        isPrintDisplayBuffer = printDisplayBuffer;
    }
}
