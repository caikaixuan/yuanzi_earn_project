package com.ygbc.brain.business.common.service.base;

public interface IExecutableService<T, V> {

    V execute(T t) throws Exception;
}
