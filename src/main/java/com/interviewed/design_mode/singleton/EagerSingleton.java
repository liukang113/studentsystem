package com.interviewed.design_mode.singleton;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: kang.liu
 * Date  : 2019/1/31 16:57
 * Description:
 */
public class EagerSingleton {

    private static EagerSingleton eagerSingleton = new EagerSingleton();

    public EagerSingleton() {
        //私有构造函数
    }

    public static EagerSingleton getInstance() {
        return eagerSingleton;
    }
}