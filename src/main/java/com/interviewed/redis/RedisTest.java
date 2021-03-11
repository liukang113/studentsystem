package com.interviewed.redis;

import org.junit.Test;
//import redis.clients.jedis.JedisShardInfo;
//import redis.clients.jedis.ShardedJedis;
//import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: kang.liu
 * @since : 2019/3/10 6:07 PM
 */
public class RedisTest {
    @Test
    public void test02() {
//        //定义redis的配置
//        PoolConfig poolconfig = new PoolConfig();
//        //表示redis的最大连接数——最大1000个线程
//        poolconfig.setMaxTotal(1000);
//        //表示最小空闲数量
//        poolconfig.setMinIdle(5);
//        //定义redis的多个节点机器
//        List<JedisShardInfo> list = new ArrayList<JedisShardInfo>();
//        //为集合添加参数
//        list.add(new JedisShardInfo("10.200.4.230", 6379));
//        list.add(new JedisShardInfo("10.200.4.230", 6380));
//        list.add(new JedisShardInfo("10.200.4.230", 6381));
//        //定义redis分片连接池
//        ShardedJedisPool jedisPool = new ShardedJedisPool(poolconfig, list);
//        //获取连接操作redis
//        ShardedJedis shardedJedis = jedisPool.getResource();
//        //向redis中添加20个记录查看分片结果
//        for (int i = 0; i < 10; i++) {
//            System.out.println("execute ......");
//            //增加的记录格式为   key=NUM_i   value=i
//            shardedJedis.set("NUM_" + i, "" + i);
//        }
    }
}
