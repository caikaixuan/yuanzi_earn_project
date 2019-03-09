package com.ygbc.brain.business.common.module;


import com.ygbc.brain.business.common.dal.dao.BaseDao;
import com.ygbc.brain.business.common.dal.data.BaseData;
import com.ygbc.brain.common.model.Page;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import com.ygbc.brain.common.utils.SpringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"unchecked", "unused"})
public class Platform {

    /**
     * 日志记录器
     */
    private static Logger logger = LoggerFactory.getLogger(Platform.class);

    /**
     * SqlSessionTemplate
     */
    private static SqlSessionTemplate sqlSessionTemplate = SpringUtils.getBean(SqlSessionTemplate.class);

    /**
     * 根据数据返回对应的DAO对象
     *
     * @return
     */
    public static <T> T getDaoBean(BaseData data) {
        return getDaoBean(data.getClass());
    }

    /**
     * 根据类型返回对应的DAO对象
     *
     * @return
     */
    public static <T> T getDaoBean(Class clazz) {
        String className = clazz.getName();
        if (!className.endsWith("Dao")) {
            className = className.replace(".data.", ".dao.").replace("Data", "Dao");
        }
        try {
            return (T) SpringUtils.getBean(Class.forName(className));
        } catch (Exception e) {
            if (e instanceof ClassNotFoundException) {
                try {
                    className = clazz.getName().replace(".model.", ".dao.").replace("Data", "Dao");
                    return (T) SpringUtils.getBean(Class.forName(className));
                } catch (Exception e1) {
                    logger.error("获取DAO对象实例失败:" + className, e);
                }
            } else {
                logger.error("获取DAO对象实例失败:" + className, e);
            }
        }
        return null;
    }

    /**
     * 根据类型返回对应的DAO对象
     *
     * @return
     */
    public static String getDaoBeanClassName(Class clazz) {
        String className = clazz.getName();
        if (!className.endsWith("Dao")) {
            className = className.replace(".data.", ".dao.").replace("Data", "Dao");
        }
        try {
            Object bean = SpringUtils.getBean(Class.forName(className));
            return className;
        } catch (Exception e) {
            if (e instanceof ClassNotFoundException) {
                try {
                    className = clazz.getName().replace(".model.", ".dao.").replace("Data", "Dao");
                    Object bean = SpringUtils.getBean(Class.forName(className));
                    return className;
                } catch (Exception e1) {
                    logger.error("获取DAO对象ClassName失败:" + className, e);
                }
            } else {
                logger.error("获取DAO对象ClassName失败:" + className, e);
            }
        }
        return null;
    }

    /**
     * 读取数据
     *
     * @param <T>
     * @return
     */
    public static <T extends BaseData> T dbRead(T data) {
        BaseDao baseDao = getDaoBean(data);
        return baseDao.selectOne(DeepBeanUtils.copyObjectToMap(data));
    }

    /**
     * 读取数据
     *
     * @param <T>
     * @return
     */
    public static <T extends BaseData> T dbRead(Class clazz, Map paramMap) {
        BaseDao baseDao = getDaoBean(clazz);
        return baseDao.selectOne(paramMap);
    }

    /**
     * 读取数据
     *
     * @param <T>
     * @return
     */
    public static <T extends BaseData> T dbRead(String statement, T data) {
        return sqlSessionTemplate.selectOne(getDaoBeanClassName(data.getClass()) + "." + statement, DeepBeanUtils.copyObjectToMap(data));
    }

    /**
     * 读取数据
     *
     * @param <T>
     * @return
     */
    public static <V extends BaseData, T> V dbReadEx(Class clazz, T data) {
        BaseDao baseDao = getDaoBean(clazz);
        return baseDao.selectOne(DeepBeanUtils.copyObjectToMap(data));
    }

    /**
     * 读取数据
     *
     * @param <T>
     * @return
     */
    public static <T extends BaseData> T dbRead(String statement, Class clazz, Map paramMap) {
        return sqlSessionTemplate.selectOne(getDaoBeanClassName(clazz) + "." + statement, paramMap);
    }

    /**
     * 读取数据
     *
     * @param <T>
     * @return
     */
    public static <V extends BaseData, T> V dbRead(String statement, Class clazz, T param) {
        return sqlSessionTemplate.selectOne(getDaoBeanClassName(clazz) + "." + statement, param);
    }

    /**
     * 读取数据
     *
     * @param <T>
     * @return
     */
    public static <V, T> V dbReadEx(String statement, Class clazz, T param) {
        return sqlSessionTemplate.selectOne(getDaoBeanClassName(clazz) + "." + statement, param);
    }

    /**
     * 读取数据
     *
     * @param <T>
     * @return
     */
    public static <T extends BaseData> T sdbRead(Class clazz, Long id) {
        BaseDao baseDao = getDaoBean(clazz);
        return baseDao.selectById(id);
    }

    /**
     * 读取数据
     *
     * @param <T>
     * @return
     */
    public static <T extends BaseData> T sdbRead(Class clazz, String code) {
        BaseDao baseDao = getDaoBean(clazz);
        return baseDao.selectByCode(code);
    }

    /**
     * 读取列表行数
     *
     * @return
     */
    public static <T extends BaseData> int dbCount(T data) {
        BaseDao baseDao = getDaoBean(data);
        return baseDao.selectCount(DeepBeanUtils.copyObjectToMap(data));
    }

    /**
     * 读取列表行数
     *
     * @return
     */
    public static <T extends BaseData> int dbCount(String statement, T data) {
        return sqlSessionTemplate.selectOne(getDaoBeanClassName(data.getClass()) + "." + statement, DeepBeanUtils.copyObjectToMap(data));
    }

    /**
     * 读取列表行数
     *
     * @return
     */
    public static int dbCount(Class clazz, Map paramMap) {
        BaseDao baseDao = getDaoBean(clazz);
        return baseDao.selectCount(paramMap);
    }

    /**
     * 读取列表行数
     *
     * @return
     */
    public static int dbCount(String statement, Class clazz, Map paramMap) {
        return sqlSessionTemplate.selectOne(getDaoBeanClassName(clazz) + "." + statement, paramMap);
    }

    /**
     * 读取列表行数
     *
     * @return
     */
    public static <T> int dbCount(String statement, Class clazz, T param) {
        return sqlSessionTemplate.selectOne(getDaoBeanClassName(clazz) + "." + statement, param);
    }

    /**
     * 读取列表
     *
     * @param <T>
     * @return
     */
    public static <T extends BaseData> List<T> dbReadSet(T data) {
        return dbReadSet(data, null, null);
    }

    /**
     * 读取列表
     *
     * @param <T>
     * @return
     */
    public static <T extends BaseData> List<T> dbReadSet(T data, Integer sortField, Integer sortType) {
        BaseDao baseDao = getDaoBean(data);
        Map paramMap = setQuerySortInfo(DeepBeanUtils.copyObjectToMap(data), sortField, sortType);
        return baseDao.select(paramMap);
    }

    /**
     * 读取列表
     *
     * @param <T>
     * @return
     */
    public static <T extends BaseData> List<T> dbReadSet(String statement, T data) {
        return dbReadSet(statement, data, null, null);
    }

    /**
     * 读取列表
     *
     * @param <T>
     * @return
     */
    public static <T extends BaseData> List<T> dbReadSet(String statement, T data, Integer sortField, Integer sortType) {
        Map paramMap = setQuerySortInfo(DeepBeanUtils.copyObjectToMap(data), sortField, sortType);
        return sqlSessionTemplate.selectList(getDaoBeanClassName(data.getClass()) + "." + statement, paramMap);
    }

    /**
     * 读取列表
     *
     * @param <T>
     * @return
     */
    public static <T extends BaseData> List<T> dbReadSet(Class clazz, Map paramMap) {
        return dbReadSet(clazz, paramMap, null, null);
    }

    /**
     * 读取列表
     *
     * @param <T>
     * @return
     */
    public static <T extends BaseData> List<T> dbReadSet(Class clazz, Map paramMap, Integer sortField, Integer sortType) {
        BaseDao baseDao = getDaoBean(clazz);
        paramMap = setQuerySortInfo(paramMap, sortField, sortType);
        return baseDao.select(paramMap);
    }

    /**
     * 读取列表
     *
     * @param <T>
     * @return
     */
    public static <T extends BaseData> List<T> dbReadSet(String statement, Class clazz, Map paramMap) {
        return dbReadSet(statement, clazz, paramMap, null, null);
    }

    /**
     * 读取列表
     *
     * @param <T>
     * @return
     */
    public static <T extends BaseData> List<T> dbReadSet(String statement, Class clazz, Map paramMap, Integer sortField, Integer sortType) {
        paramMap = setQuerySortInfo(paramMap, sortField, sortType);
        return sqlSessionTemplate.selectList(getDaoBeanClassName(clazz) + "." + statement, paramMap);
    }

    /**
     * 读取列表
     *
     * @param <T>
     * @return
     */
    public static <V extends BaseData, T> List<V> dbReadSet(String statement, Class clazz, T param) {
        return dbReadSet(statement, clazz, param, null, null);
    }

    /**
     * 读取列表
     *
     * @param <T>
     * @return
     */
    public static <V extends BaseData, T> List<V> dbReadSet(String statement, Class clazz, T param, Integer sortField, Integer sortType) {
        BaseDao baseDao = getDaoBean(clazz);
        Map paramMap = setQuerySortInfo(DeepBeanUtils.copyObjectToMap(param), sortField, sortType);
        return sqlSessionTemplate.selectList(getDaoBeanClassName(clazz) + "." + statement, param);
    }

    /**
     * 读取列表
     *
     * @param <T>
     * @return
     */
    public static <T extends BaseData> List<T> dbReadSet(T data, Page page) {
        return dbReadSet(data, page, null, null);
    }

    /**
     * 读取列表
     *
     * @param <T>
     * @return
     */
    public static <T extends BaseData> List<T> dbReadSet(T data, Page page, Integer sortField, Integer sortType) {
        BaseDao baseDao = getDaoBean(data);
        Map paramMap = setQuerySortInfo(DeepBeanUtils.copyObjectToMap(data), sortField, sortType);
        return baseDao.select(paramMap, page);
    }

    /**
     * 读取列表
     *
     * @param <T>
     * @return
     */
    public static <T extends BaseData> List<T> dbReadSet(Class clazz, Map paramMap, Page page) {
        return dbReadSet(clazz, paramMap, null, null);
    }

    /**
     * 读取列表
     *
     * @param <T>
     * @return
     */
    public static <T extends BaseData> List<T> dbReadSet(Class clazz, Map paramMap, Page page, Integer sortField, Integer sortType) {
        BaseDao baseDao = getDaoBean(clazz);
        paramMap = setQuerySortInfo(paramMap, sortField, sortType);
        return baseDao.select(paramMap, page);
    }

    /**
     * 插入数据
     *
     * @return 受影响行数
     */
    public static <T extends BaseData> int sdbInsert(T data) {
        BaseDao baseDao = getDaoBean(data);
        return baseDao.insert(data);
    }

    /**
     * 插入数据
     *
     * @return 受影响行数
     */
    public static <T extends BaseData> int sdbForceInsert(T data) {
        BaseDao baseDao = getDaoBean(data);
        return baseDao.insertForce(data);
    }

    /**
     * 更新数据
     *
     * @return 受影响行数
     */
    public static <T extends BaseData> int sdbUpdate(T data) {
        BaseDao baseDao = getDaoBean(data);
        return baseDao.update(data);
    }

    /**
     * 更新数据
     *
     * @return 受影响行数
     */
    public static <T extends BaseData> int sdbForceUpdate(T data) {
        BaseDao baseDao = getDaoBean(data);
        return baseDao.updateForce(data);
    }

    /**
     * 删除数据
     *
     * @return 受影响的行数
     */
    public static <T extends BaseData> int sdbDelete(T data) {
        BaseDao baseDao = getDaoBean(data);
        return baseDao.delete(data);
    }

    public static Map setQuerySortInfo(Map<?, ?> paramMap, Integer sortField, Integer sortType) {
        Map map = paramMap;
        if (map == null) {
            map = new HashMap<String, Object>();
        }
        if (null != sortField) {
            map.put("sortField", sortField);
        }
        if (null != sortType) {
            map.put("sortType", sortType);
        }
        return map;
    }
}
