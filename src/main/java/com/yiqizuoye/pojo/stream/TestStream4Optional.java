package com.yiqizuoye.pojo.stream;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/16 18:24
 * Description:
 */
public class TestStream4Optional {
    public static void main(String[] args) {
        String strA = " abcd ", strB = null;
        print(strA);
        print("");
        print(strB);
        int length = getLength(strA);
        System.out.println(length);
        int length1 = getLength("");
        System.out.println(length1);
        int length2 = getLength(strB);
        System.out.println(length2);
    }

    public static int getLength(String text) {
        // Java 8
        return Optional.ofNullable(text).map(String::length).orElse(-1);
        // Pre-Java 8
        // return if (text != null) ? text.length() : -1;
    }

    public static void print(String text) {
        // Java 8
        Optional.ofNullable(text).ifPresent(System.out::println);
        // Pre-Java 8
//        if (text != null) {
//            System.out.println(text);
//        }
    }

}