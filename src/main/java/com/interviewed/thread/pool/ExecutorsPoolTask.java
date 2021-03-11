package com.interviewed.thread.pool;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;


/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2019/1/31 18:38
 * Description:
 */
public class ExecutorsPoolTask {

    static ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorsPoolTask poolTask = new ExecutorsPoolTask();
        poolTask.executorTasks();
    }

    private void executorTasks() throws ExecutionException, InterruptedException {
        // 添加多个任务
        List<OperateTask> tasks = new ArrayList<OperateTask>();
        // 放在线程池中一起触发执行
        for (int i = 0; i < 10; i++) {
            tasks.add(new OperateTask(i, 10));
        }
        List<Future<BigDecimal>> futures =null;
        try {
            futures = executorService.invokeAll(tasks, 15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (futures != null) {
           for(Future<BigDecimal> bigDecimalFuture : futures){
               BigDecimal bigDecimal = bigDecimalFuture.get();

           }
        }

    }

    @AllArgsConstructor
    private class OperateTask implements Callable<BigDecimal> {
        private double price;
        private int num;

        @Override
        public BigDecimal call() throws Exception {
            Random r = new Random();
            long time = (r.nextInt(10) + 1) * 1000;
            Thread.sleep(time);
            BigDecimal d = BigDecimal.valueOf(price * num).setScale(2);
            System.out.println("耗时：" + time / 1000 + "s,单价是：" + price + ",人数是：" + num + "，总额是：" + d);
            return d;
        }
    }
}