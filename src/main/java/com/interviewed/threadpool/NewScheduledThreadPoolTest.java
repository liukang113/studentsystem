package com.interviewed.threadpool;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * @author: rockLiu
 * @date: 2021/7/4 7:02 下午
 * @desc:
 */
public class NewScheduledThreadPoolTest {

    public static void main(String[] args) {
        //创建一个定长线程池，支持定时及周期性任务执行——延迟执行
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        //延迟1秒执行
                 /*scheduledThreadPool.schedule(new Runnable() {
                     public void run() {
                        System.out.println("延迟1秒执行");
                     }
                 }, 1, TimeUnit.SECONDS);*/


        //延迟1秒后每3秒执行一次
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("延迟1秒后每3秒执行一次");
            }
        }, 1, 3, TimeUnit.SECONDS);

    }

}
