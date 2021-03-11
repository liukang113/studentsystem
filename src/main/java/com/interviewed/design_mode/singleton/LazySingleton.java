package com.interviewed.design_mode.singleton;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: kang.liu
 * Date  : 2019/1/31 16:38
 * Description:
 */
public class LazySingleton {
    /**
     * 懒汉式 单例模式：比较懒，在类加载时，不创建实例，因此类加载速度快，但运行时获取对象的速度慢
     */
    private static LazySingleton lazySingleton = null;

    private LazySingleton() {
        // 私有构造函数 <不能在别的类中来获取该类的对象，只能在类自身中得到自己的对象>
    }

    // 提供公共访问接口
    public static synchronized LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;

    }
}