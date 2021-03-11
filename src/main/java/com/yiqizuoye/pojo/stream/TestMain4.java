package com.yiqizuoye.pojo.stream;

import com.google.common.collect.Lists;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/4/27 13:09
 * Description:
 */
public class TestMain4 {

    public static void main(String[] args) {
        String sysYear = getSysYear();
        System.out.println(Integer.parseInt(sysYear));
        String yyyy = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println(yyyy);
    }

    public static String getSysYear() {
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));

        return year;
    }
}