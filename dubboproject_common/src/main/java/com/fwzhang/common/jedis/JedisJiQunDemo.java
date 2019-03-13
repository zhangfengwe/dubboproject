package com.fwzhang.common.jedis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangfengwei
 * @create 2019-03-13 14:29
 * Jedis集群操作
 */
public class JedisJiQunDemo {
    public static void main(String[] args) {
        // 第一步：使用JedisCluster对象。需要一个Set<HostAndPort>参数。Redis节点的列表。
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();//set无序但不重复
        nodes.add(new HostAndPort("127.0.0.1",7001));
        nodes.add(new HostAndPort("127.0.0.1",7002));
        nodes.add(new HostAndPort("127.0.0.1",7003));
        nodes.add(new HostAndPort("127.0.0.1",7004));
        nodes.add(new HostAndPort("127.0.0.1",7005));
        nodes.add(new HostAndPort("127.0.0.1",7006));
        JedisCluster jedisCluster = new JedisCluster(nodes);
        // 第二步：直接使用JedisCluster对象操作redis。在系统中单例存在。
        jedisCluster.set("hello", "100");
        String result = jedisCluster.get("hello");
        // 第三步：打印结果
        System.out.println(result);
        // 第四步：系统关闭前，关闭JedisCluster对象。
        try {
            jedisCluster.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
