package com.ygbc.brain.common.utils.http;

import java.io.Serializable;

/**
 * Created by ByteLee on 2016/1/22.
 */
public class ErrorResult implements Serializable {

    private String key;
    private String message;

    public ErrorResult(String key, String message) {
        this.key = key;
        this.message = message;
    }

    public ErrorResult(String key) {
        this(key, HttpMessage.getMessage(key));
    }

    public String getKey() {
        return key;
    }

    public String getMessage() {
        return message;
    }
}
