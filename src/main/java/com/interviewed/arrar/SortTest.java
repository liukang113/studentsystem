package com.interviewed.arrar;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2019/1/30 16:09
 * Description:
 */
public class SortTest {
    public static void main(String[] args) {
        int[] ints = new int[]{2, 324, 4, 57, 1};
        Arrays.sort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
        System.out.println("\n减序排序后顺序");
        //要实现减序排序，得通过包装类型数组，基本类型数组是不行滴
        Integer[] integers = new Integer[]{2, 324, 4, 4, 6, 1};
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
    }
}