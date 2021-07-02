package com.interviewed.thread.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author: kang.liu
 * @since : 2019/3/10 6:07 PM
 */
public class ThreadStanderPool {
    public static void main(String[] args) {
        int corePoolSize= Runtime.getRuntime().availableProcessors();
        int maximumPoolSize =corePoolSize;
        TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.MILLISECONDS;
        BlockingQueue<Runnable> workQueue=new LinkedBlockingDeque<>();
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, KEEP_ALIVE_TIME_UNIT.toHours(10),
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());


    }
}
