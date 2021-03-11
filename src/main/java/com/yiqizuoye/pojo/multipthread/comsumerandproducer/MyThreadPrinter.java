package com.yiqizuoye.pojo.multipthread.comsumerandproducer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: kang.liu
 * @requirement： 建立三个线程，A线程打印10次A，B线程打印10次B,C线程打印10次C，要求线程同时运行，交替打印10次ABC。
 * @since : 2019/3/10 6:07 PM
 */

@Getter
@Setter
@AllArgsConstructor
public class MyThreadPrinter implements Runnable {
    private String name;
    private Object prev;
    private Object self;


    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    // 释放自身对象锁，唤醒下一个等待线程
                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        MyThreadPrinter pa = new MyThreadPrinter("A", c, a);
        MyThreadPrinter pb = new MyThreadPrinter("B", a, b);
        MyThreadPrinter pc = new MyThreadPrinter("C", b, c);
        new Thread(pa).start();
        //确保按顺序A、B、C执行
        Thread.sleep(100);
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);
    }
}
