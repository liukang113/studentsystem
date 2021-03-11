package com.yiqizuoye.pojo.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/5/10 14:49
 * Description:
 */
public class Collection_Clear {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        while (true) {
            set.add("1");
            set.add("2");
            set.add("3");
            set.add("4");
           for(String s : set){
               System.out.println(s);
           }
            set.clear();
            System.out.println("=================="+set.size());
        }

    }
}