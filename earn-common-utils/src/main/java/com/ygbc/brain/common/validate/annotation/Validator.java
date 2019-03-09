package com.ygbc.brain.common.validate.annotation;

import com.ygbc.brain.common.validate.BaseValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validator {

    Class<? extends BaseValidator> className();

    String[] includes() default {};

    String[] excludes() default {};
}
