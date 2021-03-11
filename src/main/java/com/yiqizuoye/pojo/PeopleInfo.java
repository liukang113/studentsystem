package com.yiqizuoye.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


public class PeopleInfo {

    private String name;
    private String address;
    private Integer gender;
    private double money;
    private Integer age;

    public PeopleInfo() {
    }

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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public PeopleInfo(String name, String address, Integer gender, double money, Integer age) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.money = money;
        this.age = age;
    }



    @Override
    public String toString() {
        return "PeopleInfo{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", money=" + money +
                ", age=" + age +
                '}';
    }

    /**
     * 代码初始化
     */
    public void instance(String name, Integer age) {
        try {

            UUID.randomUUID().toString().replace("", "").toString();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
        }
    }


    public static void main(String[] args) {
        int counter=0;
        for (int i = 0; i < 10; i++) {
            System.out.println("增加");
            counter++;
            if(counter==5){
                System.out.printf("结束");
            }
        }
    }
}