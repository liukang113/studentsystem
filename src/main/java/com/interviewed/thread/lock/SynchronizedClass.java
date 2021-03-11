package com.interviewed.thread.lock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: kang.liu
 * Date  : 2019/1/31 15:11
 * Description:
 */
public class SynchronizedClass {

    public synchronized void method1() {
        method2();
    }

    private synchronized void method2() {
    }
}