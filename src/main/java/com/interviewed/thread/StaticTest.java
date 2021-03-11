package com.interviewed.thread;

/**
 * @author: kang.liu
 * @since : 2019/3/10 6:07 PM
 */
public class StaticTest {
    private static String name = "woobo";
    private String num = "X001";

    static class Person { // 静态内部类可以用public,protected,private修饰

        // 静态内部类中可以定义静态或者非静态的成员
        private String address = "China";

        private static String x = "as";
        //内部类公有成员
        public String mail = "kongbowoo@yahoo.com.cn";

        public void display() {
            // System.out.println(num);//不能直接访问外部类的非静态成员
            // 静态内部类不能访问外部类的非静态成员(包括非静态变量和非静态方法)
            // 只能直接访问外部类的静态成员
            System.out.println(name);

            //静态内部类只能访问外部类的静态成员(包括静态变量和静态方法)、
            //访问本内部类成员。
            System.out.println("Inner " + address);
        }

    }

    public void printInfo() {
        Person person = new Person();
        // 外部类访问内部类的非静态成员:实例化内部类即可
        person.display();

        //System.out.println(mail);//不可访问
        //System.out.println(address);//不可访问
        //可以访问内部类的私有成员
        System.out.println(person.address);
        // 外部类访问内部类的静态成员：内部类.静态成员
        System.out.println(Person.x);
        //可以访问内部类的公有成员
        System.out.println(person.mail);
    }

    public static void main(String[] args) {
        StaticTest staticTest = new StaticTest();
        staticTest.printInfo();
    }
}