package com.yiqizuoye.pojo.stream;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/16 14:37
 * Description:
 */
public class ProfileUtil {
    private static AtomicInteger counter = new AtomicInteger(0);

    /**
     * 长生消息id
     */
    public static long getAtomicCounter() {
        if (counter.get() > 999999) {
            counter.set(1);
        }
        long time = System.currentTimeMillis();
        long returnValue = time * 100 + counter.incrementAndGet();
        return returnValue;
    }

    private static long incrementAndGet() {
        return counter.incrementAndGet();
    }

    public static void main(String[] args) {

        System.out.println(ProfileUtil.getAtomicCounter());
        String base="IMPORTANT";
        System.out.println("IMPORTANT"==base);
    }

}