package com.yiqizuoye.pojo;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ${DESCRIPTION}
 *
 * @author : liukang
 * @date :2019-10-08 22:28
 **/
public class TestMain5 {

    public static void main(String[] args) throws InterruptedException {
        Map<Long,Long> res =new HashMap<>();
        res.put(1L,1000000L);
        int num=0;
        //System.out.println((int) ((Math.random() * 9 + 1) * 1));
        Long a =1L;
        System.out.println(res.get(a)==null?0:res.get(a).intValue());
        System.out.printf("test"+"%n");

        StringBuffer stringBuffer=new StringBuffer(10);
        stringBuffer.append("阶梯计费：%n");
        stringBuffer.append(String.format("[%s]<有效订单数<[%s]，佣金【%s】元/个；%n",
                11, 12, 1.3));
        stringBuffer.append("测试分割符");
        System.out.println(stringBuffer.toString());

        System.out.println("test>>>>>"+res.get(null));

        String onSellProdStr = "{\"B00001\":[\"20166\",\"20000\",\"20001\",\"20012\"]}";
        Map<String, Object> shopSnProds = new HashMap<String, Object>();
        shopSnProds = JSON.parseObject(onSellProdStr);
        for (Map.Entry<String, Object> entry:shopSnProds.entrySet()){
            System.out.println("key ："+entry.getKey() +"value :"+entry.getValue());
        }
    }

//    private static int incr(int num) {
//        for (int i = 0; i < 10; i++) {
//            ++num;
//        }
//        return num;
//    }
}
