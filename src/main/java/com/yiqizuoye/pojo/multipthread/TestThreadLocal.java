package com.yiqizuoye.pojo.multipthread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/4/4 11:21
 * Description:
 */
public class TestThreadLocal {

    private static final ThreadLocal<DateFormat> FORMAT_THREAD_LOCAL = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };
}