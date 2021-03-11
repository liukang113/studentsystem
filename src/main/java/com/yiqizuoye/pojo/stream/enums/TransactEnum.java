package com.yiqizuoye.pojo.stream.enums;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/16 14:26
 * Description:
 */
public enum TransactEnum {

    RED("红色", 1),
    GREEN("绿色", 2),
    BLANK("白色", 3),
    YELLOW("黄色", 4);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private TransactEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (TransactEnum c : TransactEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static void main(String[] args) {
        Set<Integer> collect = Stream.of(values()).map(TransactEnum::getIndex).collect(Collectors.toSet());
        System.out.println(collect);
    }
}