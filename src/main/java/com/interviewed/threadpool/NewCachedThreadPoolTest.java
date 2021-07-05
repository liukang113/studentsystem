package com.interviewed.threadpool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: rockLiu
 * @date: 2021/7/4 6:54 下午
 * @desc:
 */
public class NewCachedThreadPoolTest {

    public static void main(String[] args) {
        // 创建一个可缓存线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            try {
                // sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    // 打印正在执行的缓存线程信息
                    System.out.println(Thread.currentThread().getName()
                            + "正在被执行");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}