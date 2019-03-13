package com.fwzhang.common.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author zhangfengwei
 * @create 2019-03-13 9:22
 * Redis连接池
 */
public class JedisPoolDemo {

    public static void main(String[] args) {
        //创建Redis连接池配置信息对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //设置Redis连接池属性
        jedisPoolConfig.setMaxTotal(50);
        //创建Redis连接池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1");
        //获取连接
        Jedis jedis = jedisPool.getResource();

        jedis.set("age","25");

        System.out.println(jedis.get("age"));
        //归还连接
        jedisPool.returnResource(jedis);
        //释放连接池
        jedisPool.close();
    }
}
