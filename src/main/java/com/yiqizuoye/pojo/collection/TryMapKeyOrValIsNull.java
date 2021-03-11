package com.yiqizuoye.pojo.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: kang.liu
 * Date : 2019/3/3 10:17 PM
 * Eail :bjwlliuakng@163.com
 * Description:
 * 1.ConcurrentHashMap 和HashTable 不允许值和value 为NULL,两者都使用与多线程情况下，如果map.get(key)得到了null，不能判断出是因为key
 * 映射的值value为NULL，还是因为没有找到对应的key,而用于单线程状态的hashmap却可以用containKey（key） 去判断到底是否包含了这个null。
 * 2.hashtable为什么就不能containKey(key)
 * 一个线程先get(key)再containKey(key)，这两个方法的中间时刻，其他线程怎么操作这个key都会可能发生，例如删掉这个key
 */
public class TryMapKeyOrValIsNull {
    public static void main(String[] args) {
        Map<String, Integer> concurrtenMap = new ConcurrentHashMap<>();
        /*concurrtenMap.put(null, 2);*/
       /* Set<Map.Entry<String, Integer>> entries = concurrtenMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        /*for (Map.Entry<String, Integer> element : concurrtenMap.entrySet()) {
            System.out.println(element);
        }*/


        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();

        for (String data : Arrays.asList("B", "E", "D", "C", "A")) {
            hashSet.add(data);
            linkedHashSet.add(data);
            treeSet.add(data);
        }

        //不保证有序
        System.out.println("Ordering in HashSet :" + hashSet);

        //FIFO保证安装插入顺序排序
        System.out.println("Order of element in LinkedHashSet :" + linkedHashSet);

        //内部实现排序
        System.out.println("Order of objects in TreeSet :" + treeSet);
    }
}
