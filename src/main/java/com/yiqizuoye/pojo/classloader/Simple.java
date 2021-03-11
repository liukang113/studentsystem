package com.yiqizuoye.pojo.classloader;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/19 15:00
 * Description:
 */
public class Simple {

    private Simple instance;

    public void setSample(Object instance) {
        this.instance = (Simple) instance;
    }
}