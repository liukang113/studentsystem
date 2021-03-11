package com.yiqizuoye.pojo.multipthread;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: kang.liu
 * @since : 2019/3/10 6:07 PM
 */
public class BankOfThreadLocal {
    volatile
    ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 100;
        }
    };

    public int get() {
        return threadLocal.get();
    }

    public void set() {
        threadLocal.set(threadLocal.get() + 10);
    }


    public static void main(String[] args) {

        BankOfThreadLocal bank = new BankOfThreadLocal();
        for (int i = 0; i < 10; i++) {
            // ConcurrentHashMap;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    bank.set();
                    System.out.println(Thread.currentThread() + "  " + bank.get());
                }
            }).start();
        }
    }
}
