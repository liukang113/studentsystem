package com.yiqizuoye.pojo.cache;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/21 10:45
 * Description:
 */
public class SingletonMap {

    private Map localCache = Maps.newHashMap();
    /* 单例模式 */
    private static SingletonMap singletonMap;

    /**
     * 无参构造
     */
    public SingletonMap() {

    }

    /**
     * 初始化方法
     */
    public static SingletonMap instanceSingle() {
        if (singletonMap == null) {
            synchronized (SingletonMap.class) {
                if (singletonMap == null) {
                    singletonMap = new SingletonMap();
                }
            }
        }
        return singletonMap;
    }
}