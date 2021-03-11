package com.yiqizuoye.pojo.cache;

import com.google.common.cache.*;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/21 11:16
 * Description:
 */
public class GuavaCacheBuilderTest {

    public static void main(String[] args) throws Exception {
        GuavaCacheBuilderTest cache = new GuavaCacheBuilderTest();
        cache.getNameLoadingCache("bixiao");
    }

    public void getNameLoadingCache(String name) throws Exception {
        LoadingCache cache = CacheBuilder.newBuilder()
                .maximumSize(20)//设置大小，条目数
                .expireAfterWrite(20, TimeUnit.SECONDS)//设置失效时间，创建时间
                .expireAfterAccess(20, TimeUnit.HOURS) //设置时效时间，最后一次被访问
                .removalListener(new RemovalListener() { //移除缓存的监听器
                    public void onRemoval(RemovalNotification notification) {
                        System.out.println("有缓存数据被移除了");
                    }
                })
                .build(new CacheLoader() {
                    @Override
                    public Object load(Object o) throws Exception {
                        return false;
                    }
                });
        System.out.println(cache.get(name));
        //cache.invalidateAll();
    }
}