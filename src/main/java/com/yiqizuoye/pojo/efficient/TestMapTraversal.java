package com.yiqizuoye.pojo.efficient;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/15 15:37
 * Description: Map 4中遍历
 */
public class TestMapTraversal {

    public static void main(String[] args) {
        System.out.println("遍历Map集合");
        HashMap<String, Integer> map = Maps.newHashMap();
        initMap(map);
        /* 遍历元素*/
        System.out.println("===========通过Map.entrySet遍历key和value================");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("key" + entry.getKey() + ",  value" + entry.getValue());
        }

        System.out.println("===========Map.keySet遍历key================");
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println("Key = " + key + ", Value = " + value);
        }
        System.out.println("===========Map.keySet的Iterator遍历 ================");
        Iterator<Map.Entry<String, Integer>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()){
            /* 得到Map几个的Entry*/
            Map.Entry<String, Integer> entry = entryIterator.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    private static HashMap<String, Integer> initMap(HashMap<String, Integer> map) {
        map.put("001", (int) ((Math.random() * 100) % 100));
        map.put("002", (int) ((Math.random() * 100) % 100));
        map.put("003", (int) ((Math.random() * 100) % 100));
        map.put("004", (int) ((Math.random() * 100) % 100));
        map.put("005", (int) ((Math.random() * 100) % 100));
        return map;
    }


}