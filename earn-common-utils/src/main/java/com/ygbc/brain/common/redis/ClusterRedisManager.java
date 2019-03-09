package com.ygbc.brain.common.redis;

import redis.clients.jedis.JedisCluster;

public class ClusterRedisManager implements RedisManager {

    private JedisCluster jedisCluster;

    private int expire = 0;

    @Override
    public long decr(String key) {
        return jedisCluster.decr(key);
    }

    @Override
    public void del(byte[] key) {
        jedisCluster.del(key);
    }

    @Override
    public void del(String key) {
        jedisCluster.del(key);
    }

    @Override
    public long expire(String key, int seconds) {
        return jedisCluster.expire(key, seconds);
    }

    @Override
    public long expireAt(String key, int unixTimestamp) {
        return jedisCluster.expireAt(key, unixTimestamp);
    }

    @Override
    public byte[] get(byte[] key) {
        return jedisCluster.get(key);
    }

    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        String value = jedisCluster.get(key);
        return value == null ? defaultValue : value;
    }

    @Override
    public Long incr(String key) {
        return jedisCluster.incr(key);
    }

    @Override
    public byte[] set(byte[] key, byte[] value) {
        jedisCluster.set(key, value);
        if (this.expire != 0) {
            jedisCluster.expire(key, this.expire);
        }
        return value;
    }

    @Override
    public String set(String key, String value) {
        jedisCluster.set(key, value);
        if (this.expire != 0) {
            jedisCluster.expire(key, this.expire);
        }
        return value;
    }

    @Override
    public byte[] set(byte[] key, byte[] value, int expire) {
        jedisCluster.set(key, value);
        if (expire != 0) {
            jedisCluster.expire(key, expire);
        }
        return value;
    }

    @Override
    public String set(String key, String value, int second) {
        jedisCluster.set(key, value);
        if (expire != 0) {
            jedisCluster.expire(key, expire);
        }
        return value;
    }

    @Override
    public long setnx(String key, String value) {
        return jedisCluster.setnx(key, value);
    }

    public JedisCluster getJedisCluster() {
        return jedisCluster;
    }

    public void setJedisCluster(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }
}
