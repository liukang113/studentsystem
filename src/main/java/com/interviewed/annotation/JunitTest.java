package com.interviewed.annotation;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

/**
 * @author: kang.liu
 * @since : 2019/3/10 6:07 PM
 */
public class JunitTest {


    @Test
    @Autowired
    public void getRandNum() {
        for (int i = 0; i < 100; i++) {
            int random = (int) ((Math.random() * 100 + 1) % 100);
            System.out.println(random);
        }
    }

    @Hello("getFlag")
    public static boolean getFlag(){
        return false;
    }

    @Hello("getUserName")
    public static String getUserName(Integer sex){
        if(sex.equals(1)){
            return "female";
        }
        return "male";
    }

    @Hello("hello")
    public static void main(String[] args) throws NoSuchMethodException {
        Class aClass = JunitTest.class;
        Method main = aClass.getMethod("getUserName", Integer.class);
        Hello hello = main.getAnnotation(Hello.class);
        System.out.println(hello.value());

    }
}
