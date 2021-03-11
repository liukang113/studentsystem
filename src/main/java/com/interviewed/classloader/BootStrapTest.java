package com.interviewed.classloader;

import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2019/1/29 12:07
 * Description:
 */
public class BootStrapTest {
    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
    }
}