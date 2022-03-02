package com.yiqizuoye.pojo.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/6/21 11:22
 * Description:
 */
public class CountDownLatchDemo2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        System.out.println("计数器为" + countDownLatch.getCount());
        new Thread(() -> {
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + "执行完毕,计数器为" + countDownLatch.getCount());
        }, "t1").start();
        new Thread(() -> {
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + "执行完毕,计数器为" + countDownLatch.getCount());
        }, "t2").start();
        new Thread(() -> {
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + "执行完毕,计数器为" + countDownLatch.getCount());
        }, "t3").start();
        countDownLatch.await(10, TimeUnit.MILLISECONDS);//阻塞
        // countDownLatch.await();//阻塞,主线程一直在等待释放资源
        System.out.println("所有线程执行完毕");
    }

}