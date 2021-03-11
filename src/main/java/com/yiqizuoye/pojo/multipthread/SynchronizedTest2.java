package com.yiqizuoye.pojo.multipthread;

/**
 * @author: kang.liu
 * @Desc;，对静态方法的同步本质上是对类的同步（ 静态方法本质上是属于类的方法，而不是对象上的方法），所以即使test和test2属于不同的对象，但是它们都属于SynchronizedTest类的实例
 * @since : 2019/3/10 6:07 PM
 */
public class SynchronizedTest2 {
    public static synchronized void method1() {
        System.out.println("Method 1 start");
        System.out.println("Method 1 execute");
        System.out.println("Method 1 end");
    }

    public static synchronized void method2() {
        System.out.println("Method 2 start");
        System.out.println("Method 2 execute");
        System.out.println("Method 2 end");
    }

    public static void main(String[] args) {
        final SynchronizedTest test = new SynchronizedTest();
        final SynchronizedTest test2 = new SynchronizedTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test2.method2();
            }
        }).start();
    }
}
