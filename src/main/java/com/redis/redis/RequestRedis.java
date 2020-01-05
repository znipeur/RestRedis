package com.redis.redis;

public class RequestRedis {
    String key;

    public RequestRedis(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public RequestRedis() {
    }
}
