package com.yiqizuoye.pojo.stream;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/19 11:12
 * Description: 可以看到reduce方法接受一个函数，这个函数有两个参数，第一个参数是上次函数执行的返回值（也称为中间结果），
 * 第二个参数是stream中的元素，这个函数把这两个值相加，得到的和会被赋值给下次执行这个函数的第一个参数。要注意的是：
 * **第一次执行的时候第一个参数的值是Stream的第一个元素，第二个参数是Stream的第二个元素**。这个方法返回值类型是Optional，
 * 这是Java8防止出现NPE的一种可行方法，后面的文章会详细介绍，这里就简单的认为是一个容器，其中可能会包含0个或者1个对象。
 * 这个过程可视化的结果如图：
 */
public class TestStream4Reduce2 {
    public static void main(String[] args) {
        List<Integer> ints = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        /** 为防止出现NPE，函数第一次执行的时候第一个参数值是Stream中的第一个参数，第二个参数是Stream中的第二个参数 */
        List<Integer> collect = ints.stream()
                .distinct()
                .filter(data ->  data.intValue()>5 )
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println(ints.stream().reduce((sum, item) -> sum + item).get());
    }
}