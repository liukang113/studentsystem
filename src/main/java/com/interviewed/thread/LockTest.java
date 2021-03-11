package com.interviewed.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * @Author: kang.liu
 * Date  : 2019/1/30 17:22
 * Description:
 */
public class LockTest {
    public int inc = 0;
    Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockTest test = new LockTest();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        test.increase();
                    }
                }
            }.start();
        }
    }

    private void increase() {
        lock.lock();
        try {
            inc++;
        } finally {
            lock.unlock();
        }
    }
}