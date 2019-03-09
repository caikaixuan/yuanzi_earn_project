package com.ygbc.brain.common.validator;

import com.ygbc.brain.base.enums.BaseIntEnum;
import com.ygbc.brain.base.enums.BaseStrEnum;
import com.ygbc.brain.common.annotation.Enums;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

public class EnumValidator implements ConstraintValidator<Enums, Object> {

    private Enums enums;

    @Override
    public void initialize(Enums enums) {
        this.enums = enums;
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o == null) {
            if (enums.nullable()) {
                return true;
            } else {
                return false;
            }
        }
        try {
            Class clazz = enums.value();
            Method method = clazz.getMethod("values", null);
            if (method == null) {
                return false;
            }
            Object value = method.invoke(null, null);
            if (value == null) {
                return false;
            }
            if (this.hasInterface(clazz, BaseIntEnum.class)) {
                if (!(o instanceof Integer)) {
                    return false;
                }
                BaseIntEnum[] intEnums = (BaseIntEnum[]) value;
                for (BaseIntEnum intEnum : intEnums) {
                    if (intEnum.getValue() == (Integer) o) {
                        return true;
                    }
                }
            } else if (this.hasInterface(clazz, BaseStrEnum.class)) {
                if (!(o instanceof String)) {
                    return false;
                }
                BaseStrEnum[] strEnums = (BaseStrEnum[]) value;
                for (BaseStrEnum strEnum : strEnums) {
                    if (strEnum.getValue().equals(o)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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
}
