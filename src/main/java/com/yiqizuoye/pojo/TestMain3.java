package com.yiqizuoye.pojo;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/8/13 19:55
 * Description:
 */
public class TestMain3 {
    public static void main(String[] args) {

        List<String> stringList1 = Lists.newArrayList("1", "2", "3", "4", "5", "6");
        List<String> stringList2 = Lists.newArrayList("8","7");
        List<String> stringList3 = Lists.newArrayList("2", "1", "7");
        boolean result = stringList1.retainAll(stringList2);
        System.out.println(result);
        System.out.println(stringList1);
        Iterator<String> it = stringList1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        List<Object> objects = Collections.emptyList();
        System.out.println(CollectionUtils.isEmpty(objects));
        String ariseCount="234";
        if (StringUtils.isEmpty(ariseCount) || (StringUtils.isNotEmpty(ariseCount) && Integer.parseInt(ariseCount) < 500)){
            System.out.println("++++++++++++++++++++++++++++++");
        }
    }
}