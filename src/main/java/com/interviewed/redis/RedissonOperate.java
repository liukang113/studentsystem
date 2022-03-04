package com.interviewed.redis;

import java.util.Iterator;
import java.util.List;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * Description: redis 各种数据类型操作
 *
 * @author :liukang07
 * @version :1.0
 * @date :2022/3/2 5:47 下午
 */
public class RedissonOperate {

    public static void main(String[] args) {

        //1 创建redission的config对象并配置redis服务器(此处使用singleServer)
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379");
        config.useSingleServer().setDatabase(2);

        //2 创建redis客户端redissionClient
        RedissonClient redissonClient = Redisson.create(config);

        //3 使用五种数据结构
        useString(redissonClient);

        useHash(redissonClient);

        useList(redissonClient);

        useSet(redissonClient);

        useSortedSet(redissonClient);

    }

    /**
     * Hash类型
     *
     * @param redissonClient
     */
    private static void useHash(RedissonClient redissonClient) {

        RMap<Object, Object> map = redissonClient.getMap("myFirstMap");
        map.put("productId2", "100055301");

        Object productId2 = map.get("productId2");
        System.out.println(productId2);
    }

    /**
     * String 数据类型
     *
     * @param redissonClient
     */
    private static void useString(RedissonClient redissonClient) {

        RBucket<Object> bucket = redissonClient.getBucket("myString-key");
        bucket.set("{\"userName\":\"test\",\"userPwd\":\"test\",\"email\":\"xxx@163.com\",\"captcha\":\"3552\"}");

        Object o = bucket.get();
        System.out.println(o);
    }

    /**
     * List数据类型
     *
     * @param redissonClient
     */
    private static void useList(RedissonClient redissonClient) {
        List<String> list = redissonClient.getList("listKey-32");
        list.add("listValue1");
        list.add("listValue2");

        String s = list.get(0);
        System.out.println(s);
        System.out.println(list);
    }

    /**
     * Set数据类型
     *
     * @param redissonClient
     */
    private static void useSet(RedissonClient redissonClient) {
        RSet<String> set = redissonClient.getSet("setKey-32");
        set.add("setValue");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }

    /**
     * Zset数据类型
     *
     * @param redissonClient
     */
    private static void useSortedSet(RedissonClient redissonClient) {
        RScoredSortedSet<String> sortedSet
                = redissonClient.getScoredSortedSet("sortedKey-32");

        sortedSet.add(1.0, "zs");
        sortedSet.add(2.0, "lisi");

        Double score = sortedSet.getScore("zs");
        System.out.println(score);
        Integer rank = sortedSet.rank("zs");
        System.out.println(rank);
    }
}
