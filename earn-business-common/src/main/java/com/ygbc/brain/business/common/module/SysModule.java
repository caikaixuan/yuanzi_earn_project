package com.ygbc.brain.business.common.module;

import java.io.Serializable;

public class SysModule implements Serializable {

    public static final String NAME = "SysModule";
    private static final long serialVersionUID = 1033477730238782261L;
    private String classMethod;


    public String getClassMethod() {
        return classMethod;
    }

    public void setClassMethod(String classMethod) {
        this.classMethod = classMethod;
    }


}
