package com.ygbc.brain.common.validate;

import com.ygbc.brain.base.enums.BaseIntEnum;
import com.ygbc.brain.base.enums.BaseStrEnum;
import com.ygbc.brain.common.annotation.Enums;
import com.ygbc.brain.common.utils.DecimalUtils;
import com.ygbc.brain.common.utils.matcher.PatternMatcher;
import com.ygbc.brain.common.validate.annotation.Validate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseValidator {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Map<String, String> errorMap = null;

    public <T> Map<String, String> validate(Map<String, String> errorMap, T obj, String[] includes, String[] excludes) throws Exception {
        this.errorMap = errorMap;
        return validate(obj, includes, excludes);
    }

    public <T> Map<String, String> validate(T obj, String[] includes, String[] excludes) throws Exception {
        Map<String, String> errors = new HashMap<>();
        Method[] methods = this.getClass().getDeclaredMethods();
        if (methods != null) {
            for (Method method : methods) {
                Validate validate = method.getAnnotation(Validate.class);
                if (validate != null) {
                    try {
                        if (errorMap != null) {
                            if (errorMap.containsKey(validate.value())) {
                                continue;
                            }
                        }
                        Map<String, String> includeMap = this.stringArrayToMap(includes);
                        Map<String, String> excludeMap = this.stringArrayToMap(excludes);
                        if (includeMap != null && !includeMap.containsKey(validate.value())) {
                            continue;
                        }
                        if (excludeMap != null && excludeMap.containsKey(validate.value())) {
                            continue;
                        }
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        if (parameterTypes != null && parameterTypes.length >= 2) {
                            if (!obj.getClass().equals(parameterTypes[1])) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                        Object val = this.getFieldValue(this.getPropertyNode(validate.value()), obj);
                        String message = this.doBaseCheck(method, val);
                        if (message != null) {
                            errors.put(validate.value(), message);
                        } else {
                            Object error = method.invoke(this, val, obj);
                            if (error != null) {
                                errors.put(validate.value(), (String) error);
                            }
                        }
                    } catch (Exception e) {
                        logger.error("方法{}进行验证时发生异常", method.getName());
                        throw e;
                    }
                }
            }
        }
        return errors;
    }

    private <T> Object getFieldValue(List<String> nodes, T obj) throws Exception {
        if (CollectionUtils.isNotEmpty(nodes)) {
            String fieldName = nodes.get(0);
            Field field = this.getField(obj, fieldName);
            if (field == null) {
                //throw new BusinessException();
                return null;
            }
            Field.setAccessible(new Field[]{field}, true);
            Object val = field.get(obj);
            if (nodes.size() > 1) {
                //还有子节点
                if (val == null) {
                    //throw new BusinessException();
                    return null;
                } else {
                    nodes.remove(0);
                    return getFieldValue(nodes, val);
                }
            } else {
                return val;
            }
        }
        return null;
    }

    private <T> Field getField(T obj, String fieldName) throws Exception {
        Field field = null;
        try {
            field = obj.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            Class superClass = obj.getClass().getSuperclass();
            if (superClass != null) {
                try {
                    field = superClass.getDeclaredField(fieldName);
                } catch (NoSuchFieldException ex) {

                }
            }
        }
        return field;
    }

    private List<String> getPropertyNode(String fieldNode) {
        List<String> list = new ArrayList<>();
        String[] nodes = fieldNode.split("\\.");
        for (String node : nodes) {
            list.add(node);
        }
        return list;
    }

    private String doBaseCheck(Method method, Object value) throws Exception {
        NotNull notNull = method.getAnnotation(NotNull.class);
        if (notNull != null) {
            if (value == null) {
                return notNull.message();
            }
        }
        NotBlank notBlank = method.getAnnotation(NotBlank.class);
        if (notBlank != null) {
            if (value == null) {
                return notBlank.message();
            } else if (StringUtils.isBlank(String.valueOf(value))) {
                return notBlank.message();
            }
        }
        DecimalMin decimalMin = method.getAnnotation(DecimalMin.class);
        if (decimalMin != null) {
            if (value == null) {
                return decimalMin.message();
            } else {
                if (!(value instanceof BigDecimal)) {
                    return decimalMin.message();
                } else {
                    if (!DecimalUtils.gt((BigDecimal) value, new BigDecimal(decimalMin.value()))) {
                        return decimalMin.message();
                    }
                }
            }
        }
        DecimalMax decimalMax = method.getAnnotation(DecimalMax.class);
        if (decimalMax != null) {
            if (value == null) {
                return decimalMax.message();
            } else {
                if (!(value instanceof BigDecimal)) {
                    return decimalMax.message();
                } else {
                    if (!DecimalUtils.lt((BigDecimal) value, new BigDecimal(decimalMax.value()))) {
                        return decimalMax.message();
                    }
                }
            }
        }

        Enums enums = method.getAnnotation(Enums.class);
        if (enums != null) {
            if (value == null) {
                if (!enums.nullable()) {
                    return enums.message();
                }
            } else {
                Class clazz = enums.value();
                Method valueMethod = clazz.getMethod("values", null);
                if (valueMethod == null) {
                    return enums.message();
                }
                Object o = method.invoke(null, null);
                if (o == null) {
                    return enums.message();
                }

                boolean hasEnums = false;
                if (this.hasInterface(clazz, BaseIntEnum.class)) {
                    if (!(o instanceof Integer)) {
                        return enums.message();
                    }
                    BaseIntEnum[] intEnums = (BaseIntEnum[]) value;
                    for (BaseIntEnum intEnum : intEnums) {
                        if (intEnum.getValue() == (Integer) o) {
                            hasEnums = true;
                            break;
                        }
                    }
                } else if (this.hasInterface(clazz, BaseStrEnum.class)) {
                    if (!(o instanceof String)) {
                        return enums.message();
                    }
                    BaseStrEnum[] strEnums = (BaseStrEnum[]) value;
                    for (BaseStrEnum strEnum : strEnums) {
                        if (strEnum.getValue().equals(o)) {
                            hasEnums = true;
                            break;
                        }
                    }
                }
                if (!hasEnums) {
                    return enums.message();
                }
            }
        }

        Email email = method.getAnnotation(Email.class);
        if (email != null) {
            if (value == null) {
                return email.message();
            } else {
                if (!(value instanceof String)) {
                    return email.message();
                } else {
                    if (!PatternMatcher.isEmail((String) value)) {
                        return email.message();
                    }
                }
            }
        }
        return null;
    }

    private boolean hasInterface(Class clazz, Class targetClass) {
        Class[] inters = clazz.getInterfaces();
        if (inters == null) {
            return false;
        }
        for (Class inter : inters) {
            if (inter.equals(targetClass)) {
                return true;
            }
        }
        return false;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    private Map<String, String> stringArrayToMap(String[] strs) {
        if (strs != null && strs.length > 0) {
            Map<String, String> map = new HashMap<>();
            for (String str : strs) {
                map.put(str, str);
            }
            return map;
        } else {
            return null;
        }
    }
}
