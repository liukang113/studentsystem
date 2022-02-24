package com.interviewed.threadpool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Description:
 *
 * @author :liukang07
 * @version :1.0
 * @date :2022/1/13 4:02 下午
 */
public class SetWaitTimeAndReturn {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable myCallable = null;
        try {
            //创建一个Callable，3秒后返回String类型
            myCallable = new Callable() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(3000);
                    try {
                        int i = 1 / 0;
                    } catch (ArithmeticException e) {
                        System.out.println("子线程异常，主线程直接结束线程");
                        throw new Exception("子线程抛出异常");
                    }
                    System.out.println("calld方法执行了");
                    return "call方法返回值";
                }
            };
        } catch (Exception e) {
            System.out.println("主线程接住");
        }

        System.out.println("提交任务之前 " + getStringDate());
        Future future = executor.submit(myCallable);
        System.out.println("提交任务之后，获取结果之前 " + getStringDate());
        System.out.println("获取返回值: " + future.get());
        System.out.println("获取到结果之后 " + getStringDate());
    }

    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

}
