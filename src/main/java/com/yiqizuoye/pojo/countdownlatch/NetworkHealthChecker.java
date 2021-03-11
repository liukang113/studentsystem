package com.yiqizuoye.pojo.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/19 17:57
 * Description:
 */
public class NetworkHealthChecker extends BaseHealthChecker {

    public NetworkHealthChecker (CountDownLatch latch)  {
        super("Network Service", latch);
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