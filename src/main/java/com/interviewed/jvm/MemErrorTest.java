package com.interviewed.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: kang.liu
 * @Date : 2019/3/10 6:07 PM
 * Description:This is a simple class
 */
public class MemErrorTest {
    public static void main(String[] args) {
        try {
            List<Object> list = new ArrayList<Object>();
            for (; ; ) {
                //创建对象速度可能高于jvm回收速度
                list.add(new Object());
            }
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }

        try {
            hit();//递归造成StackOverflowError 这边因为每运行一个方法将创建一个栈帧，栈帧创建太多无法继续申请到内存扩展
        } catch (StackOverflowError e) {
            e.printStackTrace();
        }

    }

    private static void hit() {
        hit();
    }
}
