package com.ygbc.brain.common.annotation;

import com.ygbc.brain.base.enums.BaseEnum;
import com.ygbc.brain.common.validator.EnumValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = EnumValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Enums {

    Class<? extends BaseEnum> value();

    boolean nullable() default false;

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
