package com.yiqizuoye.pojo.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/19 18:01
 * Description:
 */
public class DatabaseHealthChecker extends BaseHealthChecker {

    public DatabaseHealthChecker (CountDownLatch latch)  {
        super("Database  Service", latch);
    }

    @Override
    public void verifyService()
    {
        System.out.println("Checking " + this.getServiceName());
//        try
//        {
//            Thread.sleep(7);
//        }
//        catch (InterruptedException e)
//        {
//            e.printStackTrace();
//        }
        System.out.println(this.getServiceName() + " is UP");
    }
}