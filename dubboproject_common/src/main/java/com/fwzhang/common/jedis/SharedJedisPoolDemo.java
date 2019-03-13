package com.fwzhang.common.jedis;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangfengwei
 * @create 2019-03-13 13:51
 */
public class SharedJedisPoolDemo {
    public static void main(String[] args) {
        // 构建连接池配置信息
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        jedisPoolConfig.setMaxTotal(50);
        // 定义集群信息
        List<JedisShardInfo> jedisShardInfoList = new ArrayList<JedisShardInfo>();
        jedisShardInfoList.add(new JedisShardInfo("127.0.0.1",6379));
        // 定义集群连接池
        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(jedisPoolConfig,jedisShardInfoList);

        ShardedJedis shardedJedis = null;

        try {
            // 从连接池中获取到jedis分片对象
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.set("sex","男");
            System.out.println(shardedJedis.get("sex"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != shardedJedis) {
                //关闭连接，检测连接是否有效，有效则放回到连接池中，无效则重置状态
                shardedJedis.close();
            }
        }
        //关闭连接池
        shardedJedisPool.close();
    }
}
