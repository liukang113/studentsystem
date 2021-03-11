package com.yiqizuoye.pojo.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/6/21 11:22
 * Description:
 */
public class CountDownLatchDemo {

    private static CountDownLatch cdl = new CountDownLatch(2);
    private static Random rnd = new Random();


    class FirstThread implements Runnable {
        private String name;

        public FirstThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("thread name " + name + " is start ");
            try {
                Thread.sleep(rnd.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cdl.countDown();
            System.out.println("----------Thread " + name + " is over");
        }
    }

    class SecondThread implements Runnable {
        private String name;

        public SecondThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread name " + name + " is start ");
            try {
                Thread.sleep(rnd.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----------Thread " + name + " is over");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        CountDownLatchDemo demo = new CountDownLatchDemo();
        executorService.submit(demo.new FirstThread("a"));
        executorService.submit(demo.new FirstThread("b"));
        executorService.submit(demo.new SecondThread("c"));
        executorService.submit(demo.new SecondThread("d"));
    }
}