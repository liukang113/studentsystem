package com.yiqizuoye.pojo.multipthread;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/20 17:57
 * Description:
 */
public class InvokeAllThread {

    // 固定大小的线程池，同时只能接受5个任务，其他的线程处于等待状态
    static ExecutorService mExecutor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {
        InvokeAllThread thread = new InvokeAllThread();
        thread.getRankedTravelQuotes();
    }

    private void getRankedTravelQuotes() throws InterruptedException {
        List<QuoteTask> tasks = new ArrayList<QuoteTask>();
        // 模拟10个计算旅游报价的任务
        for (int i = 1; i <= 20; i++) {
            /** 添加任务 */
            tasks.add(new QuoteTask(200, i));
        }
        /** 使用invokeAll方法批量提交任务，时间为预估时间  execute 去触发执行所有在线程池中的预装任务 */
        List<Future<BigDecimal>> futures = mExecutor.invokeAll(tasks, 15, TimeUnit.SECONDS);
        List<BigDecimal> totalPriceList = new ArrayList<BigDecimal>();

        Iterator<QuoteTask> taskIter = tasks.iterator();

        for (Future<BigDecimal> future : futures) {
            QuoteTask task = taskIter.next();
            try {
                totalPriceList.add(future.get());
            } catch (ExecutionException e) {
                // 返回计算失败的原因
                // totalPriceList.add(task.getFailureQuote(e.getCause()));
                totalPriceList.add(BigDecimal.valueOf(-1));
                System.out.println("任务执行异常,单价是" + task.price + "，人数是：" + task.num);
            } catch (CancellationException e) {
                // totalPriceList.add(task.getTimeoutQuote(e));
                totalPriceList.add(BigDecimal.ZERO);
                System.out.println("任务超时，取消计算,单价是" + task.price + "，人数是：" + task.num);
            }
        }
        for (BigDecimal bigDecimal : totalPriceList) {
            System.out.println(bigDecimal);
        }
        mExecutor.shutdown();
    }

    @AllArgsConstructor
    private class QuoteTask implements Callable<BigDecimal> {
        private final double price;
        public final int num;

        @Override
        public BigDecimal call() throws Exception {
            Random r = new Random();
            long time = (r.nextInt(10) + 1) * 1000;
            Thread.sleep(time);

            BigDecimal d = BigDecimal.valueOf(price * num).setScale(2);
            System.out.println("耗时：" + time / 1000 + "s,单价是：" + price + ",人数是："
                    + num + "，总额是：" + d);
            return d;
        }
    }
}