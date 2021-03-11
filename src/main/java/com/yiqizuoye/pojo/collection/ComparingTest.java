package com.yiqizuoye.pojo.collection;

import com.yiqizuoye.pojo.collection.domain.Car;
import com.yiqizuoye.pojo.collection.domain.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/5/11 10:23
 * Description:
 * 以前的排序一般对象实现Comparable或者Comparator接口，经常是通过匿名类类实现。
 * 可以参见以前的博文 Java 中 Comparable 和 Comparator 比较
 * 现在看看使用lamda表达式和java8中增强的Comparator接口进行排序。
 */
public class ComparingTest {
    public static void main(String[] args) {
        Person p1 = new Person(9, "aa");
        p1.setCars(new ArrayList<>());
        Car car10 = new Car();
        car10.setCarName("car10");
        Car car11 = new Car();
        car11.setCarName("car11");
        p1.getCars().add(car10);
        p1.getCars().add(car11);

        Person p3 = new Person(8, "aa");
        p3.setCars(new ArrayList<>());
        Car car110 = new Car();
        car110.setCarName("car10");
        Car car111 = new Car();
        car111.setCarName("car11");
        p3.getCars().add(car110);
        p3.getCars().add(car111);

        Person p2 = new Person(3, "aa");
        p2.setCars(new ArrayList<>());
        Car car20 = new Car();
        car20.setCarName("car20");
        Car car21 = new Car();
        car21.setCarName("car21");
        Car car23 = new Car();
        car23.setCarName("car23");
        p2.getCars().add(car20);
        p2.getCars().add(car21);
        p2.getCars().add(car23);

        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        // 构造条件
        Function<Person, Integer> function = person -> person.getCars().size();
        List<Person> data = personList.stream().sorted(Comparator.comparing(function).thenComparing(Person::getId).reversed()).collect(Collectors.toList());
        data.forEach(person -> {
            System.out.println(person.toString());
        });
    }

}