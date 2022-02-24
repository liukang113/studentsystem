package com.interviewed.thread.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author: kang.liu
 * @since : 2019/3/10 6:07 PM
 */
public class ThreadStanderPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        int maximumPoolSize = corePoolSize;
        TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.MILLISECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>();
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        ExecutorService pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, KEEP_ALIVE_TIME_UNIT.toHours(10),
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());

        //创建一个Callable，3秒后返回String类型
        Callable myCallable = () -> {
            Thread.sleep(3000);
            System.out.println("子线程继续执行");
            return getStringDate();
        };
        System.out.println("提交任务之前 " + getStringDate());
        Future future = pool.submit(myCallable);
        System.out.println("提交任务之后，获取结果之前 " + getStringDate());
        try {
            System.out.println("等待子线程返回数据: " + future.get(2000, TimeUnit.MILLISECONDS));
        } catch (TimeoutException e) {
            System.out.println("子线程超时");
        }
        System.out.println("主线程继续执行：获取到结果之后 " + getStringDate());
        System.exit(0);
    }

    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}
