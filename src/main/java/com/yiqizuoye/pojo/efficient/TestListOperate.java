package com.yiqizuoye.pojo.efficient;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/15 16:02
 * Description: 新特性
 */
public class TestListOperate {

    public static void main(String[] args) {
        ArrayList<Integer> list = Lists.newArrayList();
        initListCollection(list);
        ArrayList<Object> result = Lists.newArrayList();
        list.stream().distinct().filter(Objects::nonNull).forEach(data ->{
            /** 每个元素渲染 */
            if(data.intValue()>50) result.add(data);
        } );
        System.out.println(result);

    }

    private static void initListCollection(ArrayList<Integer> list) {
        list.add((int) ((Math.random()*100) %100));
        list.add((int) ((Math.random()*100) %100));
        list.add((int) ((Math.random()*100) %100));
        list.add((int) ((Math.random()*100) %100));
        list.add((int) ((Math.random()*100) %100));
        list.add((int) ((Math.random()*100) %100));
        list.add((int) ((Math.random()*100) %100));
    }
}