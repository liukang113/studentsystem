package com.interviewed.design_mode.agency.static_state;

import com.interviewed.design_mode.agency.Person;
import com.interviewed.design_mode.agency.Student;

/**
 * ${DESCRIPTION}
 *
 * @author : liukang
 * @date :2020-09-05 17:51
 **/
public class Student_StaticProxy implements Person {

    private Person person;

    public Student_StaticProxy(Person person) {
        this.person = person;
    }

    public static void main(String[] args) {
        Student student=new Student();
        Student_StaticProxy proxy=new Student_StaticProxy(student);
        proxy.sleep();
        proxy.eat();
    }

    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }
}
