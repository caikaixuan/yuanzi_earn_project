package com.ygbc.brain.business.common.context;

import com.ygbc.brain.business.common.module.SysModule;
import org.springframework.session.MapSession;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class ServiceContext {

    /**
     * 上下文容器
     */
    private static final ThreadLocal<Map<String, Object>> context = new ThreadLocal<Map<String, Object>>() {
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<>();
        }
    };
    /**
     * 单例对象
     */
    private static ServiceContext serviceContext = new ServiceContext();

    /**
     * 隐藏构造函数
     */
    private ServiceContext() {
    }

    /**
     * 获取单例对象
     *
     * @return
     */
    public static ServiceContext getInstance() {
        return serviceContext;
    }

    /**
     * 获取属性值
     *
     * @param attributeName
     * @param <V>
     * @return
     */
    public <V> V getAttribute(String attributeName) {
        if (context.get() == null) {
            return null;
        }
        return (V) context.get().get(attributeName);
    }

    /**
     * 设置属性值
     *
     * @param attributeName
     * @param attributeValue
     * @param <T>
     */
    public <T> void setAttribute(String attributeName, T attributeValue) {
        if (context.get() != null) {
            context.get().put(attributeName, attributeValue);
        }
    }

    /**
     * 获取系统模块
     *
     * @return
     */
    public SysModule getSysModule() {
        return this.getAttribute(SysModule.NAME);
    }

    /**
     * 设置系统模块
     *
     * @param sysModule
     */
    public void setSysModule(SysModule sysModule) {
        this.setAttribute(SysModule.NAME, sysModule);
    }

    /**
     * 获取会话
     *
     * @return
     */
    public MapSession getSession() {
        return this.getAttribute("Session");
    }

    /**
     * 设置会话
     *
     * @return
     */
    public void setSession(MapSession session) {
        this.setAttribute("Session", session);
    }
}
