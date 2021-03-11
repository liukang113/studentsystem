package com.interviewed.classloader;

/**
 * Created with IntelliJ IDEA.
 * @Author: kang.liu
 * Date  : 2019/1/29 14:38
 * Description:
 */
public class ClassLoaderTree {
    public static void main(String[] args) {
        // 启动类加载器是由C++编写，先是按照appClassLoader查找，
        ClassLoader loader = ClassLoaderTree.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }
        System.out.println(loader);
    }
}