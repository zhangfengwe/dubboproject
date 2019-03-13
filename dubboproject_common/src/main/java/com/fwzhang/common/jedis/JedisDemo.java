package com.fwzhang.common.jedis;

import redis.clients.jedis.Jedis;

/**
 * @author zhangfengwei
 * @create 2019-03-12 20:12
 * jedis简单使用demo
 */
public class JedisDemo {
    public static void main(String[] args) {
        //创建jedis对象
        Jedis jedis = new Jedis("127.0.0.1",6379);

        jedis.set("name","fwzhang");

        System.out.println(jedis.get("name"));
        //关闭jedis连接
        jedis.close();

    }
}
