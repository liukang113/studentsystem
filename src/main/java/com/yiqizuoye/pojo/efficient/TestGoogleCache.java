package com.yiqizuoye.pojo.efficient;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.yiqizuoye.pojo.PeopleInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/15 17:36
 * Description: 谷歌'嵌入式缓存'
 */
public class TestGoogleCache {
    public static void main(String[] args) throws ExecutionException {
        ArrayList<PeopleInfo> list = Lists.newArrayList();

        list.add(new PeopleInfo(UUID.randomUUID().toString().replace("-", "").substring(0, 12), "测试数据 ", 1, Math.random(), 1));
        list.add(new PeopleInfo(UUID.randomUUID().toString().replace("-", "").substring(0, 12), "测试数据 ", 2, Math.random(), 1));
        list.add(new PeopleInfo(UUID.randomUUID().toString().replace("-", "").substring(0, 12), "测试数据 ", 3, Math.random(), 1));
        list.add(new PeopleInfo(UUID.randomUUID().toString().replace("-", "").substring(0, 12), "测试数据 ", 4, Math.random(), 1));
        list.add(new PeopleInfo(UUID.randomUUID().toString().replace("-", "").substring(0, 12), "测试数据 ", 1, Math.random(), 1));
        list.add(new PeopleInfo(UUID.randomUUID().toString().replace("-", "").substring(0, 12), "测试数据 ", 1, Math.random(), 1));

        /** 创建 cache */
        LoadingCache<Integer, PeopleInfo> cache = CacheBuilder.newBuilder().
                concurrencyLevel(Runtime.getRuntime().availableProcessors() - 1).initialCapacity(1024).build(new CacheLoader<Integer, PeopleInfo>() {
            @Override
            public PeopleInfo load(Integer key) throws ExecutionException {
                System.out.println(key + " load in cache");
                return getPeopleByKey(key);
            }

            private PeopleInfo getPeopleByKey(Integer key) {
                System.out.println(key + " query");
                for (PeopleInfo peopleInfo : list) {
                    if (peopleInfo.getGender().intValue() == key.intValue()) return peopleInfo;
                }
                return null;
            }
        });
        cache.get(1);
        cache.get(2);
        cache.get(3);
        System.out.println("======= sencond time  ==========");
        cache.get(1);
        cache.get(2);
        cache.get(3);
    }
}