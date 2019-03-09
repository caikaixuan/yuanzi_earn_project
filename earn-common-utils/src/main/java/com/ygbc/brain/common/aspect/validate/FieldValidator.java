package com.ygbc.brain.common.aspect.validate;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.common.exception.ValidateException;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.*;

/**
 * 功能: 字段基础校验器
 * 创建: liuchongguang - liuchongguang@zillionfortune.com
 * 日期: 2017/2/10 0010 09:27
 * 版本: V1.0
 */
@Component
public class FieldValidator {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public <T> Resp validate(T obj) {
        Set<ConstraintViolation<T>> set = validator.validate(obj, Default.class);
        if (CollectionUtils.isNotEmpty(set)) {
            for (ConstraintViolation<T> cv : set) {
                return Resp.build(Constants.PARAM_VALIDATE_ERROR_CODE, cv.getMessage());
            }
        }
        return null;
    }

    public <T> Resp validateField(T obj) {
        Set<ConstraintViolation<T>> set = validator.validate(obj, Default.class);
        if (CollectionUtils.isNotEmpty(set)) {
            for (ConstraintViolation<T> cv : set) {
                throw new ValidateException(Constants.PARAM_VALIDATE_ERROR_CODE, cv.getMessage());
            }
        }
        return null;
    }

    public <T> List<String> validateErrors(T obj) {
        List<String> errorList = new ArrayList<>();
        Set<ConstraintViolation<T>> set = validator.validate(obj, Default.class);
        if (CollectionUtils.isNotEmpty(set)) {
            for (ConstraintViolation<T> cv : set) {
                errorList.add(cv.getMessage());
            }
        }
        return errorList;
    }

    public <T> Map<String, String> validateFieldErrors(T obj) {
        Map<String, String> errors = new HashMap<>();
        Set<ConstraintViolation<T>> set = validator.validate(obj, Default.class);
        if (CollectionUtils.isNotEmpty(set)) {
            for (ConstraintViolation<T> cv : set) {
                errors.put(this.getFieldPath(cv.getPropertyPath()), cv.getMessage());
            }
        }
        return errors;
    }

    private String getFieldPath(Path path) {
        if (path != null) {
            Iterator<Path.Node> iterator = path.iterator();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (iterator.hasNext()) {
                Path.Node node = iterator.next();
                if (i > 0) {
                    sb.append(node.getName()).append(".");
                }
                i++;
            }
            if (i > 1) {
                return sb.substring(0, sb.length() - 1);
            }
        }
        return null;
    }

//    public static <T> ValidatorResult validateProperty(T obj,String propertyName){
//        ValidatorResult result = new ValidatorResult();
//        Set<ConstraintViolation<T>> set = validator.validateProperty(obj,propertyName,Default.class);
//        if( CollectionUtils.isNotEmpty(set) ){
//            result.setHasErrors(true);
//            Map<String,String> errorMsg = new HashMap<String,String>();
//            for(ConstraintViolation<T> cv : set){
//                errorMsg.put(propertyName, cv.getMessage());
//            }
//            result.setErrorMsg(errorMsg);
//        }
//        return result;
//    }
}
