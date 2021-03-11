package com.yiqizuoye.pojo.countdownlatch;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/20 10:35
 * Description:
 */
public class TestCountDownLatch {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestCountDownLatch.class);

    public static void main(String[] args) {
        int threadCount = 10;
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < threadCount; i++) {
            int index = i;
            new Thread(() -> {
                StopWatch watch = new StopWatch(index + "");
                watch.start();
                System.out.println("线程" + Thread.currentThread().getId() + "开始出发");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                watch.stop();

                System.out.println("线程" + Thread.currentThread().getId() + "已到达终点");
                latch.countDown();
            }).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}