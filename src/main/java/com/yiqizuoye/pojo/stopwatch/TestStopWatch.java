package com.yiqizuoye.pojo.stopwatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/6/6 21:00
 * Description:
 */
public class TestStopWatch {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestStopWatch.class);

    private void test() throws InterruptedException {
        StopWatch sw = new StopWatch("接口测试");

        sw.start("起床");
        Thread.sleep(1000);
        sw.stop();

        sw.start("洗漱");
        Thread.sleep(2000);
        sw.stop();

        sw.start("锁门");
        Thread.sleep(500);
        sw.stop();
//        LOGGER.info("耗时信息\n"+sw.prettyPrint()+"总耗时:"+sw.getTotalTimeMillis());
        LOGGER.info("获取信息\n" + sw.prettyPrint());
//        System.out.println(sw.prettyPrint());
//        System.out.println(sw.getTotalTimeMillis());
//        System.out.println(sw.getLastTaskName());
//        System.out.println(sw.getLastTaskInfo());
//        System.out.println(sw.getTaskCount());
    }


//    public static void main(String[] argv) throws InterruptedException {
//        TestStopWatch testStopWatch = new TestStopWatch();
//        testStopWatch.test();
//    }

    //    public static void main(String[] args) throws Exception
//    {
//        String pattern1 = "{0},你好!你于 {1} 存入 {2}元";
//        String pattern2 = "At {1,time,short} on {1,date,long},{0} paid {2,number,currency}";
//
//        //1.0E3 科学计数法 即 1.0*10^3 E3表示10的三次方
//        Object[] params = {"hoonick",new GregorianCalendar().getTime(),1.0E3};
//
//        //使用默认的本地化对象格式化字符串
//        String format = MessageFormat.format(pattern1, params);
//        System.out.println(format);
//
//        //使用指定的本地化对象格式化字符串
//        MessageFormat mf = new MessageFormat(pattern2, Locale.US);
//        String format2 = mf.format(params);
//        System.out.println(format2);
//    }
    /*public static void main(String[] args) throws UnsupportedEncodingException {
        String url = "http%3a%2f%2fm.jd.com";
        // System.out.println(URLDecoder.decode(url,"UTF-8"));
        System.out.println(URLU);
    }*/

    public static void main(String[] args) {
        getFlag();
        System.out.println();
    }

    private static boolean getFlag() {
        return false;
    }

}