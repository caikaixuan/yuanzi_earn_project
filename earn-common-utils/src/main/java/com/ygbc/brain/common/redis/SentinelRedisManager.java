package com.ygbc.brain.common.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

public class SentinelRedisManager implements RedisManager {

    private JedisSentinelPool jedisSentinelPool;

    private int expire = 0;

    @Override
    public long decr(String key) {
        Jedis jedis = jedisSentinelPool.getResource();
        try {
            return jedis.decr(key);
        } finally {
            jedis.close();
        }
    }

    @Override
    public void del(byte[] key) {
        Jedis jedis = jedisSentinelPool.getResource();
        try {
            jedis.del(key);
        } finally {
            jedis.close();
        }
    }

    @Override
    public void del(String key) {
        Jedis jedis = jedisSentinelPool.getResource();
        try {
            jedis.del(key);
        } finally {
            jedis.close();
        }
    }

    @Override
    public long expire(String key, int seconds) {
        if (key == null || key.equals("")) {
            return 0;
        }
        Jedis jedis = jedisSentinelPool.getResource();
        try {
            return jedis.expire(key, seconds);
        } finally {
            jedis.close();
        }
    }

    @Override
    public long expireAt(String key, int unixTimestamp) {
        if (key == null || key.equals("")) {
            return 0;
        }
        Jedis jedis = jedisSentinelPool.getResource();
        try {
            return jedis.expireAt(key, unixTimestamp);
        } finally {
            jedis.close();
        }
    }

    @Override
    public byte[] get(byte[] key) {
        byte[] value = null;
        Jedis jedis = jedisSentinelPool.getResource();
        try {
            value = jedis.get(key);
        } finally {
            jedis.close();
        }
        return value;
    }

    @Override
    public String get(String key) {
        String value = null;
        Jedis jedis = jedisSentinelPool.getResource();
        try {
            value = jedis.get(key);
        } finally {
            jedis.close();
        }
        return value;
    }

    @Override
    public String get(String key, String defaultValue) {
        Jedis jedis = jedisSentinelPool.getResource();
        try {
            String value = jedis.get(key);
            return value == null ? defaultValue : value;
        } finally {
            jedis.close();
        }
    }

    @Override
    public Long incr(String key) {
        Jedis jedis = jedisSentinelPool.getResource();
        try {
            return jedis.incr(key);
        } finally {
            jedis.close();
        }
    }

    @Override
    public byte[] set(byte[] key, byte[] value) {
        Jedis jedis = jedisSentinelPool.getResource();
        try {
            jedis.set(key, value);
            if (this.expire != 0) {
                jedis.expire(key, this.expire);
            }
        } finally {
            jedis.close();
        }
        return value;
    }

    @Override
    public String set(String key, String value) {
        Jedis jedis = jedisSentinelPool.getResource();
        try {
            jedis.set(key, value);
        } finally {
            jedis.close();
        }
        return value;
    }

    @Override
    public byte[] set(byte[] key, byte[] value, int expire) {
        Jedis jedis = jedisSentinelPool.getResource();
        try {
            jedis.set(key, value);
            if (expire != 0) {
                jedis.expire(key, expire);
            }
        } finally {
            jedis.close();
        }
        return value;
    }

    @Override
    public String set(String key, String value, int second) {
        Jedis jedis = jedisSentinelPool.getResource();
        ;
        try {
            jedis.setex(key, second, value);
        } finally {
            jedis.close();
        }
        return value;
    }

    @Override
    public long setnx(String key, String value) {
        Jedis jedis = jedisSentinelPool.getResource();
        try {
            return jedis.setnx(key, value);
        } finally {
            jedis.close();
        }
    }

    public JedisSentinelPool getJedisSentinelPool() {
        return jedisSentinelPool;
    }

    public void setJedisSentinelPool(JedisSentinelPool jedisSentinelPool) {
        this.jedisSentinelPool = jedisSentinelPool;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }
}
