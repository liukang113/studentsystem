package com.yiqizuoye.pojo.collect;

import com.yiqizuoye.pojo.entity.Item;
import com.yiqizuoye.pojo.entity.PeopleInfo;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/13 11:09
 * Description:
 */
public class TestStream {

    public static void main(String[] args) {
        System.out.println("测试数据 ########################");
        Map<String, PeopleInfo> map = new HashMap<>();
        map.put(UUID.randomUUID().toString().replace("-", "").substring(0, 12), PeopleInfo.instance());
        map.put(UUID.randomUUID().toString().replace("-", "").substring(0, 12), PeopleInfo.instance());
        map.put(UUID.randomUUID().toString().replace("-", "").substring(0, 12), PeopleInfo.instance());
        map.put(UUID.randomUUID().toString().replace("-", "").substring(0, 12), PeopleInfo.instance());
        map.put(UUID.randomUUID().toString().replace("-", "").substring(0, 12), PeopleInfo.instance());
        System.out.println(map);
        System.out.println("测试集合的Stream 方法#####################");

        //3 apple, 2 banana, others 1
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );
        System.out.println("数据分组< 按照某一个属性 #######################>");
        //group by price
        Map<BigDecimal, List<Item>> groupByPriceMap =
                items.stream().collect(Collectors.groupingBy(Item::getPrice));
        System.out.println(groupByPriceMap);
        // group by price, uses 'mapping' to convert List<Item> to Set<String>
        System.out.println("数据分组再压平 ############################");
        Map<BigDecimal, Set<String>> result =
                items.stream().collect(
                        Collectors.groupingBy(Item::getPrice,
                                Collectors.mapping(Item::getName, Collectors.toSet())
                        )
                );
        System.out.println(result);
        if (items.isEmpty()) return;

        System.out.println();
    }
}