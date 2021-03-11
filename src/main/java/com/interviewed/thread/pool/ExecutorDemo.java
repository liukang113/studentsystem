package com.interviewed.thread.pool;

import java.util.Map;
import java.util.concurrent.*;


/**
 * 【强制】线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，
 * 这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
 * <p>
 * 因为自己经常使用Executors提供的工厂方法创建线程池，所以忽略了线程池内部的实现。
 * 特别是拒绝策略，面试被问到两次，因为使用Executors创建线程池不会传入这个参数而使用默认值所以我们常常忽略这一参数，
 * 还好因为这条建议，自己提前熟悉了一下ThreadPoolExecutor。
 */
public class ExecutorDemo {

    public static void main(String[] args) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();


        int cpuNums = Runtime.getRuntime().availableProcessors();
        System.out.println(cpuNums);
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(cpuNums);
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(8);

        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();


        /**
         * corePoolSize - 线程池核心池的大小。
         maximumPoolSize - 线程池的最大线程数。
         keepAliveTime - 当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间。
         unit - keepAliveTime 的时间单位。
         workQueue - 用来储存等待执行任务的队列。
         threadFactory - 线程工厂。
         handler - 拒绝策略。
         */
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(1024), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        }, new ThreadPoolExecutor.AbortPolicy());

        pool.execute(() -> System.out.println(Thread.currentThread().getName()));
        pool.shutdown();

        Map<String, Integer> map = new ConcurrentHashMap<>();
    }
}
