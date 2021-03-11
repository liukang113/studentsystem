package com.yiqizuoye.pojo.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/19 18:00
 * Description:
 */
public class ApplicationStartupUtil { //List of service checkers
    // 实现BaseHealthChecker的所有服务
    private static List<BaseHealthChecker> _services;

    //This latch will be used to wait on
    private static CountDownLatch _latch;

    private ApplicationStartupUtil() {
    }

    private final static ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();

    public static ApplicationStartupUtil getInstance() {
        return INSTANCE;
    }

    /**
     * 1.init lath，
     * 2.thread pool,
     * 3.execute task
     */
    public static boolean checkExternalServices() throws Exception {
        //Initialize the latch with number of service checkers
        _latch = new CountDownLatch(3);

        //All add checker in lists
        _services = new ArrayList<BaseHealthChecker>();
        _services.add(new NetworkHealthChecker(_latch));
        _services.add(new CacheHealthChecker(_latch));
        _services.add(new DatabaseHealthChecker(_latch));

        //Start service checkers using executor framework
        Executor executor = Executors.newFixedThreadPool(_services.size());

        for (final BaseHealthChecker v : _services) {
            executor.execute(v);
        }

        //Now wait till all services are checked
        /**1.与CountDownLact 第一次交互是主线程等待其他的线程。主线程必须在启动其他线程后立即调用CountDownLatch.wait方法，
         * 这样主线程的操作就在这个方法上阻塞，直到其他线程执行完各自的任务。
         * 2.其他N 个线程必须引用闭锁对象，因为他们需要通知CountDownLatch对象，他们已经完成了各自的任务。这种通知机制是通过 CountDownLatch.countDown()方法来完成的；每调用一次这个方法，在构造函数中初始化的count值就减1。
         * 所以当N个线程都调 用了这个方法，count的值等于0，然后主线程就能通过await()方法，恢复执行自己的任务。*/

        _latch.await();

        //Services are file and now proceed startup
        for (final BaseHealthChecker v : _services) {
            System.out.println("闭锁的数量为：-------->"+_latch.getCount());
            if (!v.isServiceUp()) {
                return false;
            }
        }
//        _latch.countDown();
        return true;
    }
}