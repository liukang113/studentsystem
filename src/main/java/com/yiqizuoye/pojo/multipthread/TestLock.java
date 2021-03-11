package com.yiqizuoye.pojo.multipthread;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/8/23 10:59
 * Description:
 */
public class TestLock {
    private static List<Integer> data = Lists.newArrayList();
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                lock.lock();// 获取锁
                try {
                    System.out.println(thread.getName() + "得到了锁");
                    for (int i = 0; i < 10; i++) {
                        data.add(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(thread.getName() + "释放了锁");
                    lock.unlock();
                }
            }
        }.start();


        new Thread() {
            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                lock.lock();
                try {
                    System.out.println(thread.getName() + "得到了锁");
                } catch (Exception e) {
                    // TODO handle exception
                } finally {
                    System.out.println(thread.getName() + "释放了锁");
                    lock.unlock();
                }
            }
        }.start();
    }
}