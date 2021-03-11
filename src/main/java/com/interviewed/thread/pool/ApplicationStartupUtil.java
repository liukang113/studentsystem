package com.interviewed.thread.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.yiqizuoye.pojo.countdownlatch.BaseHealthChecker;
import com.yiqizuoye.pojo.countdownlatch.CacheHealthChecker;
import com.yiqizuoye.pojo.countdownlatch.DatabaseHealthChecker;
import com.yiqizuoye.pojo.countdownlatch.NetworkHealthChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: kang.liu
 * @Date : 2019/3/10 6:07 PM
 * Description:This is a simple class
 */
public class ApplicationStartupUtil {
    /**
     * List of service checkers
     */
    private static List<BaseHealthChecker> _services;

    /**
     * This latch will be used to wait on
     */
    private static CountDownLatch _latch;

    private ApplicationStartupUtil() {
        super();
    }

    private final static ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();

    public static ApplicationStartupUtil getInstance() {
        return INSTANCE;
    }

    public static boolean checkExternalServices() throws Exception {
        //Initialize the latch with number of service checkers
        _latch = new CountDownLatch(3);

        //All add checker in lists
        _services = new ArrayList<BaseHealthChecker>();
        _services.add(new NetworkHealthChecker(_latch));
        _services.add(new CacheHealthChecker(_latch));
        _services.add(new DatabaseHealthChecker(_latch));

        // Start service checkers using executor framework
        // Executor executor = Executors.newFixedThreadPool(_services.size());
        int size = _services.size();
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
        ExecutorService executor = new ThreadPoolExecutor(size, size, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(),namedThreadFactory);
        /**
         * 使用带有ThreadFactory参数的ThreadPoolExecutor 构造方法，方便设置线程名称
         */

        for (final BaseHealthChecker v : _services) {
            executor.execute(v);
        }

        //Now wait till all services are checked
        try {
            _latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Services are file and now proceed startup
        for (final BaseHealthChecker v : _services) {
            if (!v.isServiceUp()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = false;
        try {
            result = ApplicationStartupUtil.checkExternalServices();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("External services validation completed !! Result was :: " + result);
    }
}
