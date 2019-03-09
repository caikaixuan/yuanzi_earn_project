package com.ygbc.brain.common.aspect;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.context.ServiceContext;
import com.ygbc.brain.business.common.module.SysModule;
import com.ygbc.brain.common.session.RedisSessionManager;
import com.ygbc.brain.common.token.annotation.NoLogin;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.session.MapSession;

import java.lang.reflect.Method;

public class LoginTokenValidateAspect {

    private static Logger logger = LoggerFactory.getLogger(LoginTokenValidateAspect.class);

    private RedisSessionManager redisSessionManager;

    /**
     * 参数校验切面处理
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        NoLogin noLogin = method.getAnnotation(NoLogin.class);
        if (noLogin != null || method.getName().startsWith("_")) {
            return pjp.proceed();
        } else {
            //获取当前执行方法
            Object[] args = pjp.getArgs();
            for (Object arg : args) {
                if (arg instanceof Req) {
                    Req req = (Req) arg;
                    MapSession session = redisSessionManager.doVerify(req.getLoginName(), req.getSessionId());
                    if (session == null) {
                        return Resp.build(Constants.INVALID_TOKEN_ERROR_CODE, Constants.INVALID_TOKEN_ERROR_MSG);
                    }
                    ServiceContext context = ServiceContext.getInstance();
                    context.setSession(session);
                    SysModule sysModule = session.getAttribute(SysModule.NAME);
                    if (sysModule != null) {
                        String classMethod = method.getDeclaringClass().getName() + "." + method.getName();
                        sysModule.setClassMethod(classMethod);
                        context.setSysModule(sysModule);
                    }
                    break;
                }
            }
            return pjp.proceed();
        }
    }

    public RedisSessionManager getRedisSessionManager() {
        return redisSessionManager;
    }

    public void setRedisSessionManager(RedisSessionManager redisSessionManager) {
        this.redisSessionManager = redisSessionManager;
    }

}
