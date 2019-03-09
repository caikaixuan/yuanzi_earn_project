package com.ygbc.brain.base.rpc;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Map;

public class Resp<T> implements Serializable {

    /**
     * 默认分页大小
     */
    public static final Integer DEFAULT_PAGE_SIZE = 10;
    private static final long serialVersionUID = -8759939181697622791L;
    /**
     * 页码(当前页)
     */
    private Integer pageNo = 1;

    /**
     * 分页大小(每页数量)
     */
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 总页数
     */
    private Integer totalPage = 0;

    /**
     * 总记录数
     */
    private Integer totalCount = 0;

    /**
     * 响应码
     */
    private String respCode = "0000";

    /**
     * 响应内容
     */
    private String respMsg = "成功";

    /**
     * 附加信息
     */
    private String addition;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 字段校验异常
     */
    private Map<String, String> errors;

    /**
     * 默认构造
     */
    public Resp() {
    }

    /**
     * 重载构造
     *
     * @param respCode 业务响应码
     * @param respMsg  业务响应描述
     */
    public Resp(String respCode, String respMsg) {
        this.respCode = respCode;
        this.respMsg = respMsg;
    }

    public Resp(String respCode, String respMsg, Map<String, String> errors) {
        this.respCode = respCode;
        this.respMsg = respMsg;
        this.errors = errors;
    }

    /**
     * 重载构造
     *
     * @param respCode 业务响应码
     * @param respMsg  业务响应描述
     * @param addition 附加信息
     */
    public Resp(String respCode, String respMsg, String addition) {
        this.respCode = respCode;
        this.respMsg = respMsg;
        this.addition = addition;
    }

    /**
     * 构建RPC响应对象
     *
     * @param clazz 类
     * @param <T>   RPC响应对象类型
     * @return RPC响应对象
     */
    public static <T> T build(Class clazz) {
        Object object = null;
        try {
            object = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) object;
    }

    /**
     * 构建RPC响应对象
     *
     * @return RPC响应对象
     */
    public static Resp build() {
        return new Resp();
    }

    /**
     * 构建RPC响应对象
     *
     * @param respCode 业务响应码
     * @param respMsg  业务响应描述
     * @return RPC响应对象
     */
    public static Resp build(String respCode, String respMsg) {
        return new Resp(respCode, respMsg);
    }

    /**
     * 构建RPC响应对象
     *
     * @param respCode 业务响应码
     * @param respMsg  业务响应描述
     * @return RPC响应对象
     */
    public static Resp build(String respCode, String respMsg, Map<String, String> errors) {
        return new Resp(respCode, respMsg, errors);
    }

    /**
     * 构建RPC响应对象
     *
     * @param respCode 业务响应码
     * @param respMsg  业务响应描述
     * @param addition 附加信息
     * @return RPC响应对象
     */
    public static Resp build(String respCode, String respMsg, String addition) {
        return new Resp(respCode, respMsg, addition);
    }

    /**
     * 构建RPC响应对象
     *
     * @return RPC响应对象
     */
    public static <T> Resp<T> build(T object) {
        Resp<T> resp = new Resp<>();
        resp.setData(object);
        return resp;
    }

    /**
     * 构建RPC响应对象
     *
     * @return RPC响应对象
     */
    public static <T> Resp<T> build(String respCode, String respMsg, T object) {
        Resp<T> resp = new Resp<>(respCode, respMsg);
        resp.setData(object);
        return resp;
    }

    /**
     * 构建RPC响应对象
     *
     * @return RPC响应对象
     */
    public static <T> Resp<T> build(String respCode, String respMsg, String addition, T object) {
        Resp<T> resp = new Resp<>(respCode, respMsg, addition);
        resp.setData(object);
        return resp;
    }

    /**
     * 构建RPC响应对象
     *
     * @return RPC响应对象
     */
    public static <T> Resp<T> build(Integer pageNo, Integer pageSize, int totalCount, T object) {
        Resp<T> resp = new Resp<>();
        resp.setPageNo(pageNo);
        resp.setPageSize(pageSize);
        resp.setTotalCount(totalCount);
        resp.setData(object);
        return resp;
    }

    /**
     * 构建RPC响应对象
     *
     * @param clazz    类
     * @param respCode 业务响应码
     * @param respMsg  业务响应描述
     * @param <T>      RPC响应对象类型
     * @return RPC响应对象类型
     */
    public static <T> Resp<T> build(Class<T> clazz, String respCode, String respMsg) {
        Resp<T> resp = new Resp<>(respCode, respMsg);
        return resp;
    }

    /**
     * 构建RPC响应对象
     *
     * @param clazz    类
     * @param respCode 业务响应码
     * @param respMsg  业务响应描述
     * @param addition 附加信息
     * @param <T>      RPC响应对象类型
     * @return RPC响应对象类型
     */
    public static <T> Resp<T> build(Class<T> clazz, String respCode, String respMsg, String addition) {
        Resp<T> resp = new Resp<>(respCode, respMsg, addition);
        return resp;
    }

    /**
     * 反射调用类方法
     *
     * @param clazz      类
     * @param methodName 方法名称
     * @param classes    方法参数类型
     * @param object     调用对象
     * @param objects    方法参数
     * @return 调用对象
     */
    private static Object invokeMethod(Class clazz, String methodName, final Class[] classes, Object object, Object... objects) {
        try {
            Method method = getMethod(clazz, methodName, classes);
            if (method != null) {
                method.invoke(object, objects);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 反射获取类方法
     *
     * @param clazz      类
     * @param methodName 方法名称
     * @param classes    方法参数类型
     * @return 方法对象
     */
    private static Method getMethod(Class clazz, String methodName, final Class[] classes) {
        Method method = null;
        try {
            method = clazz.getDeclaredMethod(methodName, classes);
        } catch (NoSuchMethodException e) {
            try {
                method = clazz.getMethod(methodName, classes);
            } catch (NoSuchMethodException ex) {
                if (clazz.getSuperclass() != null) {
                    method = getMethod(clazz.getSuperclass(), methodName, classes);
                }
            }
        }
        return method;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 获得当前页的页号,序号从1开始,默认为1.
     */
    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * 设置当前页的页号,序号从1开始,低于1时自动调整为1.
     */
    public void setPageNo(Integer pageNo) {
        if (pageNo == null) {
            this.pageNo = pageNo;
        } else {
            this.pageNo = (pageNo < 1) ? 1 : pageNo;
        }
    }

    /**
     * 获得每页的记录数量,默认为DEFAULT_PAGESIZE.
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页的记录数量,低于1时自动调整为DEFAULT_PAGESIZE.
     */
    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            this.pageSize = pageSize;
        } else {
            this.pageSize = (pageSize < 1) ? DEFAULT_PAGE_SIZE : pageSize;
        }
    }

    /**
     * 取得总记录数, 默认值为0.
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * 设置总记录数, 默认值为0.
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = (totalCount < 0) ? 0 : totalCount;
    }

    /**
     * 总页数.
     */
    public Integer getTotalPage() {
        if (pageSize == null) {
            return 1;
        } else {
            totalPage = totalCount / pageSize;
            if (totalCount % pageSize > 0) {
                totalPage++;
            }
            return totalPage;
        }
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
