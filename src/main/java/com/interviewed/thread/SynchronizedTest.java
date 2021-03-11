package com.interviewed.thread;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2019/1/30 17:19
 * Description:
 */
public class SynchronizedTest {
    public int inc = 0;

    public static void main(String[] args) {
        SynchronizedTest test = new SynchronizedTest();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        test.increase();
                    }
                }
            }.start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(test.inc);
    }

    private synchronized void increase() {
        inc++;
    }
}