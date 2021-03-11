package com.yiqizuoye.pojo.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: kang.liu
 * Date  : 2019/3/14 11:50 PM
 * Email :bjwlliuakng@163.com
 * Description:This is a simple class
 */
public class LinkedListTest {
    public static void main(String[] args) {
        List<String> stringList = new LinkedList<String>();
        stringList.add(UUID.randomUUID().toString().replace("-","").substring(10));
        stringList.add(UUID.randomUUID().toString().replace("-","").substring(10));
        stringList.add(UUID.randomUUID().toString().replace("-","").substring(10));
        stringList.forEach(s -> System.out.println(s));

        System.out.println("测试get方法");
        System.out.println(stringList.get(0));
    }
}
