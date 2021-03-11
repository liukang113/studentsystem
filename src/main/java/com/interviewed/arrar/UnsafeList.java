package com.interviewed.arrar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2019/1/28 14:52
 * Description: ArrayList 线程是否安全验证
 * <>
 *   由此可见是ArrayList做add操作时候，会丢失一些数据，所以所Array是线程不安全的。
 *   在ArrayList 在多线程操作时，Arrays.copys 会重新覆盖原来的元素、生成新的复制对象
 * </>
 */
public class UnsafeList {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            test();
        }
    }

    private static void test() throws InterruptedException {
        List<Object> list = new ArrayList<>();
        int threadNum = 100;
        // 用来让主线等待(threadNum) 个子线程执行完成
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(new MyThreadTask(list, countDownLatch));
            thread.start();
        }
        // 主线程等待
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }

}

class MyThreadTask implements Runnable {
    private List<Object> list;
    private CountDownLatch countDownLatch;

    public MyThreadTask(List<Object> list, CountDownLatch countDownLatch) {
        this.list = list;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            list.add(new Object());
        }
        // 主线程等待子线程执行完毕再执行
        countDownLatch.countDown();
    }
}