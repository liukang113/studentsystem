package com.interviewed.thread.synchroniz_no_extends;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2019/1/31 17:23
 * Description:
 */
public class Child extends Parent {

    @Override // 重写方法
    public void test() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child " + Thread.currentThread().getName() + ":" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final Child child = new Child();
        new Thread() {
            @Override
            public void run() {
                child.test();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                child.test();
            }
        }.start();
    }
}