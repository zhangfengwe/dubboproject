package com.fwzhang.common.jedis;

import redis.clients.jedis.Jedis;

/**
 * @author zhangfengwei
 * @create 2019-03-12 20:12
 */
public class JedisDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6637);
    }
}
