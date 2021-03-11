package com.yiqizuoye.pojo.efficient;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/15 18:31
 * Description:
 */
public class TestMutliMap {
    public static void main(String[] args) {
        Multimap<String, String> linkedHashMultimap = LinkedHashMultimap.create();
        // 添加键值对
        linkedHashMultimap.put("Fruits", "Bannana");
        //给Fruits元素添加另一个元素 
        linkedHashMultimap.put("Fruits", "Apple");
        linkedHashMultimap.put("Fruits", "Pear");
        linkedHashMultimap.put("Vegetables", "Carrot");

        // 获得multimap的size
        int size = linkedHashMultimap.size();
        System.out.println(size);  // 4
        System.out.println(linkedHashMultimap);


        // 获得Fruits对应的所有的值
        Collection<String> fruits = linkedHashMultimap.get("Fruits");
        System.out.println(fruits); // [Bannana, Apple, Pear]
        Set<String> set = linkedHashMultimap.keySet();
        System.out.println(set);

        System.out.println("遍历元素 ");
        //遍历Mutlimap
        for(String value : linkedHashMultimap.values()) {
            System.out.println(value);
        }

        // Removing a single value
        linkedHashMultimap.remove("Fruits","Pear");
        System.out.println(linkedHashMultimap.get("Fruits")); // [Bannana, Pear]

        // Remove all values for a key
        linkedHashMultimap.removeAll("Fruits");
        System.out.println(linkedHashMultimap.get("Fruits")); // [] (Empty Collection!)
    }
}