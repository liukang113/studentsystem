package com.yiqizuoye.pojo.multipthread.comsumerandproducer;

import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/8/23 16:13
 * Description:
 */
public class Comsumer implements Runnable {
    BlockingQueue<String> queue;

    public Comsumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        // 消费队列中的任务
        try {
            System.out.println(Thread.currentThread().getName());
            //如果队列为空，会阻塞当前线程
            String temp = queue.take();
            System.out.println(temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}