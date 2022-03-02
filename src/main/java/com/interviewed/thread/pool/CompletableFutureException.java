package com.interviewed.thread.pool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Description:
 *
 * @author :liukang07
 * @version :1.0
 * @date :2022/3/2 2:23 下午
 */
public class CompletableFutureException {
    public static void main(String[] args) {
        test();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void test() {
        System.out.println("开始");
        CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.MILLISECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 抛出异常，引发异常处理机制
               /* if (true) {
                    throw new NullPointerException();
                }*/
                System.out.println("返回张三");
                return "ZHANGSAN";
            }
        }).exceptionally(new Function<Throwable, String>() {
            @Override
            public String apply(Throwable throwable) {
                System.out.println("触发异常机制，throwable" + throwable.getMessage());
                return "发生异常";
            }
        }).whenCompleteAsync(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) {
                System.out.println("accept :" + s);
            }
        });
        System.out.println("运行至此.");
    }
}
