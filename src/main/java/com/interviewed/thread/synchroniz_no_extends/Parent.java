package com.interviewed.thread.synchroniz_no_extends;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2019/1/31 17:22
 * Description:
 */
public class Parent {
    public synchronized void test() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Parent " + Thread.currentThread().getName() + ":" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final Parent parent = new Parent();
        new Thread() {
            @Override
            public void run() {
                parent.test();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                parent.test();
            }
        }.start();
    }
}