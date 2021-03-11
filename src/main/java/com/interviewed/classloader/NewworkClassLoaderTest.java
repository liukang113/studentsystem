package com.interviewed.classloader;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2019/1/29 14:18
 * Description:
 */
public class NewworkClassLoaderTest {
    public static void main(String[] args) {
        //测试加载网络中的class文件
        try {
            String rootUrl = "http://localhost:8080/httpweb/classes";
            String className = "org.classloader.simple.NetClassLoaderSimple";
            NetworkClassLoader ncl1 = new NetworkClassLoader(rootUrl);
            NetworkClassLoader ncl2 = new NetworkClassLoader(rootUrl);
            Class<?> clazz1 = ncl1.loadClass(className);
            Class<?> clazz2 = ncl2.loadClass(className);
            Object obj1 = clazz1.newInstance();
            Object obj2 = clazz2.newInstance();
            clazz1.getMethod("setNetClassLoaderSimple", Object.class).invoke(obj1, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

@Getter
@Setter
class NetworkClassLoader {

    private String rootUrl;

    public NetworkClassLoader(String rootUrl) {
        this.rootUrl = rootUrl;
    }

    public Class<?> loadClass(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }
}