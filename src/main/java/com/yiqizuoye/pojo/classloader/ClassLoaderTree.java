package com.yiqizuoye.pojo.classloader;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/19 14:39
 * Description:
 */
public class ClassLoaderTree {
    public static void main(String[] args) {
        /**
         * 第一个输出的是 ClassLoaderTree类的类加载器，即系统类加载器。它是 sun.misc.Launcher$AppClassLoader类的实例；
         * 第二个输出的是扩展类加载器，是 sun.misc.Launcher$ExtClassLoader类的实例。
         * 需要注意的是这里并没有输出引导类加载器，这是由于有些 JDK 的实现对于父类加载器是引导类加载器的情况，getParent()方法返回 null。
         * */
        ClassLoader loader = ClassLoaderTree.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }
        /**
         * java 虚拟机是如何判定两个java类是相同的，java虚拟机不仅要看类的全名是否一致，同时也要看两个类的父类加载器是否一致
         * 1.类名
         * 2.父类加载器
         * 只有两者都相同，才能认为是相同的两个类。 父类加载器不一致，编译的字节码不同
         * */
    }
}