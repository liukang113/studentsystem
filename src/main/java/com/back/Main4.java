package com.back;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 *
 * @author : liukang
 * @version : 1.0
 * @date :2020-10-19 23:05
 * @since : 1.0
 **/
public class Main4 {

    public static void main(String[] args){
        Map<MapKey,String> map = new HashMap<MapKey, String>();
        //第一阶段
        for (int i = 0; i < 6; i++) {
            map.put(new MapKey(String.valueOf(i)), "A");
        }
        //第二阶段
        for (int i = 0; i < 10; i++) {
            map.put(new MapKey(String.valueOf(i)), "A");
        }
        //第三阶段
        for (int i = 0; i < 50; i++) {
            map.put(new MapKey(String.valueOf(i)), "A");
        }
        //第四阶段
        map.put(new MapKey("Z"), "B");
        map.put(new MapKey("J"), "B");
        map.put(new MapKey("F"), "B");
        System.out.println(map);
    }


    private static class MapKey {
        private String name;

        public MapKey(String name) {
            this.name = name;
        }
    }
}
