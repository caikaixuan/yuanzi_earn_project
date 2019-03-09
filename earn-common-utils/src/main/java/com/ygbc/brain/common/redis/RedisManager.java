package com.ygbc.brain.common.redis;

public interface RedisManager {

    long decr(String key);

    void del(byte[] key);

    void del(String key);

    long expire(String key, int seconds);

    long expireAt(String key, int unixTimestamp);

    byte[] get(byte[] key);

    String get(String key);

    String get(String key, String defaultValue);

    Long incr(String key);

    byte[] set(byte[] key, byte[] value);

    String set(String key, String value);

    byte[] set(byte[] key, byte[] value, int expire);

    String set(String key, String value, int second);

    long setnx(String key, String value);
}
