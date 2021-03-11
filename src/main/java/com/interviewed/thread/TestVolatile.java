package com.interviewed.thread;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2019/1/30 17:04
 * Description:
 */
public class TestVolatile {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final TestVolatile test = new TestVolatile();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
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

}