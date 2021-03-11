package com.yiqizuoye.pojo.multipthread.comsumerandproducer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/8/23 17:48
 * Description:
 */
public class TestMain {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingDeque<>(2);
        Comsumer comsumer = new Comsumer(queue);
        Producer producer = new Producer(queue);
        //
        for (int i = 0; i < 3; i++) {
            new Thread(producer, "Producer" + (i + 1)).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(comsumer, "Consumer" + (i + 1)).start();
        }

    }
}