package com.yiqizuoye.pojo.collection;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/29 14:47
 * Description:  测试的List不能添加元素
 */
public class TestCollections {
    public static void main(String[] args) {

        List<Object> emptyList = Collections.emptyList();
        emptyList.add(UUID.randomUUID().toString().replace("-","").substring(0,12));
        System.out.println(emptyList);
    }
}