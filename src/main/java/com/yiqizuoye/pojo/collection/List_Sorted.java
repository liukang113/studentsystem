package com.yiqizuoye.pojo.collection;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/5/14 17:02
 * Description:
 */
public class List_Sorted {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        list.add(1036016);
        list.add(1036001);
        list.add(1036008);
        list.add(1036015);
        list.add(1036017);
        list.add(1036012);
        list.add(1036002);
        list.add(1036010);
        list.add(1036014);

        String[] defined = {"玫瑰", "牡丹", "月季", "荷花"};
        final List<String> definedOrder = Arrays.asList(defined);
        String[] toBeOrdered = {"玫瑰", "牡丹", "月季", "荷花", "月季", "牡丹", "月季", "荷花", "月季","梅花","丁香"};
        List<String> toBeOrderedList = Arrays.asList(toBeOrdered);

        Collections.sort(toBeOrderedList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int io1 = definedOrder.indexOf(o1);
                int io2 = definedOrder.indexOf(o2);
                return  io2-io1 ;
            }
        });
        System.out.println(toBeOrderedList);

    }


}