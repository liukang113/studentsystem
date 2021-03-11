package com.interviewed.classloader;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2019/1/29 14:12
 * Description:
 * JVM是如何判定两个class是否相同？
 * <>
 * 1.不仅要判断两个类名是否相同，而且还要判断是否由同一个类加载器实力加载的，只有两者都满足的情况下JVM才认为这两个class相同
 * 2.就算两个class是同一份字节码，如果被两个不同的classLoader实例加载，jvm也会认为他是两个不同的class
 * </>
 */
public class NetClassLoaderSimple {
    private NetClassLoaderSimple instance;

    public void setNetClassLoaderSimple(Object object) {
        this.instance = (NetClassLoaderSimple) object;
    }
}