package com.yiqizuoye.pojo.stream;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/4/27 13:09
 * Description:
 */
public class TestMain3 {

    public static void main(String[] args) {
        List<Integer> objects = Lists.newArrayList();
        objects.add(2);
        objects.add(7);
        objects.add(1);
        objects.add(3);
        objects.add(5);
//        int i = objects.indexOf(3);
//        System.out.println(objects.get(objects.size()-2));
//        System.out.println(objects.toString());
//        System.out.println(objects.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).collect(Collectors.toList()));
//        Set<String> set=new HashSet<>();
//        set.add("1");
//        set.add("3");
//        set.add("3");
//
//       set.removeAll(set);
//        List<Integer> objectsCP=objects;
        for (int i = 0; i < objects.size(); i++) {
            System.out.println(objects);
            objects.remove(i);
        }
    }
}