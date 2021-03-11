package com.interviewed.thread.lock.sychronized;

/**
 * @author: kang.liu
 * @since : 2019/3/10 6:07 PM
 */
public class ServiceBlock {

    public static void printA() {
        synchronized (Service.class) {
            try {
                System.out.println("threadName：" + Thread.currentThread().getName() + "进入printA");
                Thread.sleep(3000);
                System.out.println("threadName：" + Thread.currentThread().getName() + "离开printA");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printB() {
        synchronized (Service.class) {
            try {
                System.out.println("threadName：" + Thread.currentThread().getName() + "进入printB");
                Thread.sleep(3000);
                System.out.println("threadName：" + Thread.currentThread().getName() + "离开printB");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized public void printC() {
        try {
            System.out.println("threadName：" + Thread.currentThread().getName() + "进入printC");
            Thread.sleep(3000);
            System.out.println("threadName：" + Thread.currentThread().getName() + "离开printC");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ThreadD threadD = new ThreadD();
        threadD.setName("d");
        threadD.start();

        ThreadE threadE = new ThreadE();
        threadE.setName("e");
        threadE.start();

        ThreadF threadF = new ThreadF(new ServiceBlock());
        threadF.setName("f");
        threadF.start();

    }


}

class ThreadD extends Thread {
    @Override
    public void run() {
        ServiceBlock.printA();
    }
}

class ThreadE extends Thread {
    @Override
    public void run() {
        ServiceBlock.printB();
    }
}

class ThreadF extends Thread {
    private ServiceBlock serviceBlock;

    public ThreadF(ServiceBlock serviceBlock) {
        this.serviceBlock = serviceBlock;
    }

    @Override
    public void run() {
        serviceBlock.printC();
    }
}



