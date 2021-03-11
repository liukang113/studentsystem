package com.yiqizuoye.pojo;

import org.junit.Test;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/8/23 19:00
 * Description:
 */
public class TestMain4 {
    public static void main(String[] args) {
        PeopleInfo peopleInfo = new PeopleInfo();
        peopleInfo.setAddress("1212");
        peopleInfo.setAge(1);
        System.out.println(peopleInfo);

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
//        integers.addAll(null);
        System.out.println("===========================");
        Map map=new HashMap();
        map.put("age",12);
        map.put("name","lk");
        Map map1 = convertMapRef(map);
        System.out.println(map);
        System.out.println(map1);

    }

    private static Map convertMapRef(Map map) {

        map.put("address","BJ");
        map=null;
        return map;
    }

    @Test
    public void testReference(){
        PeopleInfo peopleInfo = new PeopleInfo();
        peopleInfo.setAddress("1212");
        peopleInfo.setAge(1);

        peopleInfo = changeValue(peopleInfo);
        System.out.println(peopleInfo);
    }

    private PeopleInfo changeValue(PeopleInfo peopleInfo) {
        peopleInfo.setAge(2);
        return peopleInfo;
    }

    @Test
    public void testFieldProcess() {
        Integer data = 5;
        data = processData(data);
        System.out.println(data);
    }

    private Integer processData(Integer data) {
        ++data;
        return data;
    }

    @Test
    public void getTimeStamp() {
        //方法 一
        System.out.println(System.currentTimeMillis());
        //方法 二
        System.out.println(Calendar.getInstance().getTimeInMillis());
        //方法 三
       //  System.out.println(new Date().getTime());

    }


    @Test
    public void getThreadSleep() {


    }


}