package com.interviewed.arrar;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2019/1/28 11:19
 * Description:
 */
public class ArrayKPTest {
    public static void main(String[] args) {
        List list = new LinkedList();// 源数组
        list.add(UUID.randomUUID().toString().replace("-", "").substring(10));
        list.add(UUID.randomUUID().toString().replace("-", "").substring(10));
        list.add(UUID.randomUUID().toString().replace("-", "").substring(10));
        list.add(UUID.randomUUID().toString().replace("-", "").substring(10));
        list.add(UUID.randomUUID().toString().replace("-", "").substring(10));
        byte[] srcBytes = new byte[]{2, 4, 0, 0, 0, 0, 0, 10, 15, 50};  // 源数组
        byte[] destBytes = new byte[5]; // 目标数组
        System.arraycopy(srcBytes, 0, destBytes, 0, 5);
        System.out.println();
    }
    // 数组的实现

}