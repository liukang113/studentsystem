package com.yiqizuoye.pojo.collection;

import com.yiqizuoye.pojo.collection.domain.Person;

import java.util.TreeSet;
import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: kang.liu
 * Date  : 2019/3/3 11:05 PM
 * Email :bjwlliuakng@163.com
 * Description:This is a simple class
 */
public class TreeSetSorted {
    public static void main(String[] args) {
        TreeSet<Person> treeSet=new TreeSet<>();

        Person person1=new Person(1,"LK1");
        Person person2=new Person(2,"LK223");
        Person person3=new Person(3,"LK23323213");
        Person person4=new Person(4,"LK2323");
        treeSet.add(person1);
        treeSet.add(person2);
        treeSet.add(person3);
        treeSet.add(person4);


       for(Person person:treeSet){
           System.out.println(person.getId()+"==========="+person.getName());
       }

    }
}
