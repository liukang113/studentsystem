package com.interviewed.thread.wait;

/**
 * @Author:liulanger
 */
public class MyWaitTest implements Runnable {
    private String name;
    private Object prev;
    private Object self;

    public MyWaitTest(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        MyWaitTest threadA = new MyWaitTest("A", c, a);
        MyWaitTest threadB = new MyWaitTest("B", a, b);
        MyWaitTest threadC = new MyWaitTest("C", b, c);
        new Thread(threadA).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(threadB).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(threadC).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    //  释放自身持有的对象锁，唤醒wait-set中的等待资源
                    self.notify();
                }
                try {
                    // 释放pre自身持有的对象，终止当前线程，等待线程结束后再次被唤醒
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
