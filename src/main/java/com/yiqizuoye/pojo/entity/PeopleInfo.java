package com.yiqizuoye.pojo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/13 11:15
 * Description:
 */
@Getter
@Setter
@AllArgsConstructor
public class PeopleInfo implements Serializable {
    /**
     * 姓名
     */
    private String name;
    /**
     * 住址
     */
    private String address;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 财富
     */
    private Double finance;
    /**
     * 性别
     */
    private Integer gender;

    public PeopleInfo() {
    }

    /**
     * 教育程度
     */
    private Integer educationStatus;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getFinance() {
        return finance;
    }

    public void setFinance(Double finance) {
        this.finance = finance;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getEducationStatus() {
        return educationStatus;
    }

    public void setEducationStatus(Integer educationStatus) {
        this.educationStatus = educationStatus;
    }

    @Override
    public String toString() {
        return "PeopleInfo{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", finance=" + finance +
                ", gender=" + gender +
                ", educationStatus=" + educationStatus +
                '}';
    }

    public static  PeopleInfo instance() {
        PeopleInfo peopleInfo = new PeopleInfo();

        peopleInfo.setAddress(UUID.randomUUID().toString().replace("","-").substring(0,12));
        peopleInfo.setAge(Integer.MAX_VALUE);
        peopleInfo.setFinance(Double.MAX_VALUE);
        peopleInfo.setGender((int) (((Math.random())*100)%100));
        peopleInfo.setGender(1);
        peopleInfo.setName(UUID.randomUUID().toString().replace("-",""));
        return peopleInfo;
    }

}