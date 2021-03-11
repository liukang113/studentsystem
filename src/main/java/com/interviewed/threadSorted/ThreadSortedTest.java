package com.interviewed.threadSorted;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ${DESCRIPTION}
 *
 * @author : liukang
 * @date :2020-09-03 01:29
 **/
public class ThreadSortedTest {

    @Test
    public void sortedByJoin() {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
            }, "线程" + i));
        }

        threads.forEach(thread -> {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

    @Test
    public void sortedBySingleThreadExecutor(){
        // newFixThreadExecutor 适用于对内存压力不是很敏感，但对系统负载有要求的系统
        // newCacheThreadExecutor 适用于不低延迟的短期场景
        // newSingleThreadExecutor 适用于需要异步执行但需要保证任务顺序的场景
        // newScheduledThreadExecutor 适用于定期执行任务场景
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+1);
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+2);
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+3);
            }
        });
        executorService.shutdown();
    }


}
