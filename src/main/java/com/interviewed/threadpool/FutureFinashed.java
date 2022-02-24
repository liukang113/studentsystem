package com.interviewed.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author :liukang07
 * @version :1.0
 * @date :2022/2/16 11:43 上午
 */
public class FutureFinashed {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        ThreadPoolExecutor poolExecutor =
                new ThreadPoolExecutor(3, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        CountDownLatch test = new CountDownLatch(20);
        List<Long> result = new ArrayList<>();
        list.stream().forEach(item -> {
            Callable callable = new Callable<Long>() {
                @Override
                public Long call() throws Exception {
                    try {
                        Thread.sleep(1000);
                        System.out.println(item);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        //这个不管是否异常都需要数量减,否则会被堵塞无法结束
                        test.countDown();
                    }
                    return test.getCount();
                }
            };
            Future future = poolExecutor.submit(callable);
            try {
                result.add((Long) future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        // 保证线程池中的所有的线任务都完成后，主线程才会继续向下执行；
        test.await();
        // 关闭线程池
        poolExecutor.shutdown();
        System.out.println("------over----");
        result.forEach(aLong -> {
            System.out.println(aLong);
        });
    }
}
