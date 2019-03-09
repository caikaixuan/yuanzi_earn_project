package com.ygbc.brain.business.common.listener;

public interface Listener<T> {

    void notify(T t) throws Exception;

}