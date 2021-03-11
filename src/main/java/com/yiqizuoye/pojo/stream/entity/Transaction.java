package com.yiqizuoye.pojo.stream.entity;


import com.yiqizuoye.pojo.stream.enums.TransactEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/16 14:16
 * Description:
 */

public class Transaction implements Serializable {
    private long id;
    private Integer saleCount;
    private String name;
    private TransactEnum type;
    private int value;

    public Transaction(long id, Integer saleCount, String name, TransactEnum type, int value) {
        this.id = id;
        this.saleCount = saleCount;
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TransactEnum getType() {
        return type;
    }

    public void setType(TransactEnum type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", saleCount=" + saleCount +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", value=" + value +
                '}';
    }
}