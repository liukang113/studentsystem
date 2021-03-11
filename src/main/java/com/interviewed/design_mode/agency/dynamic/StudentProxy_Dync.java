package com.interviewed.design_mode.agency.dynamic;

import com.interviewed.design_mode.agency.Person;
import com.interviewed.design_mode.agency.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ${DESCRIPTION}
 *
 * @author : liukang
 * @date :2020-09-05 17:54
 **/
public class StudentProxy_Dync implements InvocationHandler {
    private Object object;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(object,args);
        return null;
    }

    public static void main(String[] args) {
        //创建需要被代理的类
        Student s = new Student();
        StudentProxy_Dync dync=new StudentProxy_Dync();
        Person proxy = (Person) Proxy.newProxyInstance(s.getClass().getClassLoader(),s.getClass().getInterfaces(),dync);
        proxy.eat();
    }
}
