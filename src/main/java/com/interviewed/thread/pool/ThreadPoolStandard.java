package com.interviewed.thread.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author: kang.liu
 * @Date : 2019/3/10 6:07 PM
 * Description:This is a simple class
 * 根据阿里创建线程池规范：
 * 线程池不允许使用 Executors 去创建,而是通过 ThreadPoolExecutor 的方式,这样的处理方式让写的同学更加明确线程池的运行规则,规避资源耗尽的风险。
 */
public class ThreadPoolStandard {
    /**
     * Executors 返回的线程池对象的弊端如下:
     * 1)FixedThreadPool 和 SingleThreadPool : 允 许 的 请 求 队 列 长 度 为
     * Integer.MAX_VALUE,可能会堆积大量的请求,从而导致 OOM;
     * 2)CachedThreadPool 和 ScheduledThreadPool : 允 许 的 创 建 线 程 数 量 为
     * Integer.MAX_VALUE,可能会创建大量的线程,从而导致 OOM。
     */
    public static void main(String[] args) {

        int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
        int KEEP_ALIVE_TIME = 1;
        TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
        ExecutorService service=Executors.newFixedThreadPool(KEEP_ALIVE_TIME);
        BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>();
        ExecutorService executorService = new ThreadPoolExecutor
                (NUMBER_OF_CORES,
                        NUMBER_OF_CORES * 2,
                        KEEP_ALIVE_TIME,
                        KEEP_ALIVE_TIME_UNIT,
                        taskQueue);

        // 方式二
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        //Common Thread Pool
        ExecutorService pool = new ThreadPoolExecutor(5, 200, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        pool.execute(() -> System.out.println(Thread.currentThread().getName()));
        pool.shutdown();//gracefully shutdown

    }
}
