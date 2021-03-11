package com.yiqizuoye.pojo;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/4/27 13:09
 * Description:
 */
public class TestMain2 {

    public static void main(String[] args) {
        List list1 =new ArrayList();
        list1.add("A");
        list1.add("B");
        list1.add("C");

        List list2 =new ArrayList();
        list2.add("C");
        list2.add("D");
        list2.add("E");
        //无重复并集
        list2.removeAll(list1);
        list1.addAll(list2);
        System.out.println(list2);
        System.out.println(list1);


        System.out.println(new StringBuilder()
                .append("LISTENING").append(",")
                .append("MEMORIZATION").append(",")
                .append("ORAL").toString().length());

        int group=1;
        switch (group){
            case 1:
                while(true){
                    group++;
                    if(group==3){
                        break;
                    }

                    System.out.println("只执行A");
                }
            case 3:
                System.out.println("继续");
//                break;
            default:
                System.out.println("必须执行");
        }




    }
}