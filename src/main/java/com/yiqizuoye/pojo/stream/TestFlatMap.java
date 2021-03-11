package com.yiqizuoye.pojo.stream;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/16 21:14
 * Description:  min/max/distinct
 */
public class TestFlatMap {
    public static void main(String[] args) throws IOException {
        /*BufferedReader br = new BufferedReader(new FileReader("d:\\log\\u2i.log"));*/
       /* int longest = br.lines().peek(System.out::println).
                mapToInt(String::length).
                max().
                getAsInt();
        br.close();
        System.out.println(longest);*/

       /* List<String> words = br.lines().
                flatMap(line -> Stream.of(line.split(" "))).
                filter(word -> word.length() > 0).
                map(String::toUpperCase).
                distinct().
                sorted().
                collect(Collectors.toList());
        br.close();
        System.out.println(words);*/


        /**获取单词，并且去重**/

        List<String> list = Arrays.asList("beijing changcheng", "beijing gugong", "beijing tiantan", "gugong tiananmen");
        list.stream().map(item -> Arrays.stream(item.split(" "))).forEach(stringStream -> {
            stringStream.forEach(System.out::println);
        });
        System.out.println("测试数据");
        list.stream().flatMap(s -> Arrays.stream(s.split(" "))).collect(Collectors.toList()).forEach(System.out::println);
    }
    double textRate = 0.09;

}