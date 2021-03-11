package com.interviewed.arrar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2019/1/28 11:40
 * Description:
 */
public class ArrayCRUD {
    private long[] array;
    private int length = 0;
    static final int N = 50000;

    // 构造
    public ArrayCRUD(int size) {
        array = new long[size];
    }

    // 添加
    public void insert(long item) {
        array[length++] = item;
    }

    // 查询
    public boolean find(long item) {
        for (int i = 0; i < length; i++) {
            if (array[i] == item) {
                return true;
            }
        }
        return false;
    }

    // 返回下标
    public int indexOf(long item) {
        for (int i = 0; i < length; i++) {
            if (array[i] == item) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除数组中元素(先查找，后移动数组元素,维护下标)
     *
     * @param item
     * @return
     */
    public boolean delete(long item) {

        int i;
        for (i = 0; i < length; i++) {
            if (item == array[i]) {
                break;// 得到待删除数据元素位置
            }
        }
        // 移动数组中元素
        if (i == length) {
            return false;
        }

        // 后面的元素向前移动
        for (int j = i; j < length - 1; j++) {
            array[j] = array[j + 1];
        }
        length--;
        return true;
    }

    public void show() {
        System.out.print("[.");
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ",");
            }
        }
        System.out.print("]\n");
    }

    static long timeList(List list) {
        // 实现list同步
        List list2 = Collections.synchronizedList(new LinkedList<>());
        long start = System.currentTimeMillis();
        Object o = new Object();
        for (int i = 0; i < N; i++) {
            list.add(0, o);
        }
        return System.currentTimeMillis() - start;
    }

    public static void main(String[] args) {

//        ArrayCRUD crud = new ArrayCRUD(10);
//        crud.insert(1);
//        crud.insert(2);
//        crud.insert(3);
//        crud.delete(4);
//        crud.find(1);
//        crud.show();
        System.out.println("ArrayList耗时：" + timeList(new ArrayList()));
        System.out.println("LinkedList耗时：" + timeList(new LinkedList()));
    }
}