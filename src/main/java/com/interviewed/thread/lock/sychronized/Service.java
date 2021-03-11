package com.interviewed.thread.lock.sychronized;

/**
 * @author: kang.liu
 * @since : 2019/3/10 6:07 PM
 */
public class Service {

    synchronized public static void printA() {
        try {
            System.out.println("threadName：" + Thread.currentThread().getName() + "进入printA");
            Thread.sleep(500);
            System.out.println("threadName：" + Thread.currentThread().getName() + "离开printA");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    synchronized public static void printB() {
        try {
            System.out.println("threadName：" + Thread.currentThread().getName() + "进入printB");
            Thread.sleep(500);
            System.out.println("threadName：" + Thread.currentThread().getName() + "离开printB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    synchronized public  void printC() {
        try {
            System.out.println("threadName：" + Thread.currentThread().getName() + "进入printC");
            Thread.sleep(3000);
            System.out.println("threadName：" + Thread.currentThread().getName() + "离开printC");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ThreadA threadA=new ThreadA();
        threadA.setName("A-thread");
        threadA.start();

        ThreadB threadB=new ThreadB();
        threadB.setName("B-thread");
        threadB.start();

        ThreadC threadC= new ThreadC(new Service());
        threadC.setName("C-thread");
        threadC.start();
    }
}

class ThreadA extends Thread {
    @Override
    public void run() {
        Service.printA();
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        Service.printB();
    }
}
class ThreadC extends Thread {
    private Service service;

    public ThreadC(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.printC();
    }
}

