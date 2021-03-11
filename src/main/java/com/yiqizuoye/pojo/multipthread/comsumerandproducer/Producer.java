package com.yiqizuoye.pojo.multipthread.comsumerandproducer;

import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/8/23 16:14
 * Description:
 */
public class Producer implements Runnable {
    BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        // 提交任务
        try {
            System.out.println("I have made a product:" + Thread.currentThread().getName());
            String temp = "A Product, 生产线程：" + Thread.currentThread().getName();
            queue.put(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}