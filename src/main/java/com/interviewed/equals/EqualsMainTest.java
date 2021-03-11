package com.interviewed.equals;

/**
 * @Author: kang.liu
 * @Date : 2019/3/10 6:07 PM
 * Description:This is a simple class
 */
public class EqualsMainTest {
    /**
     * == 的作用：
     * 　　基本类型：比较的就是值是否相同
     * 　　引用类型：比较的就是地址值是否相同
     * equals 的作用:
     * 　　引用类型：默认情况下，比较的是地址值。
     * 注：不过，我们可以根据情况自己重写该方法。一般重写都是自动生成，比较对象的成员变量值是否相同
     */

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = new String("Hello");
        String str4 = "Hello";
        // 引用传递
        String str3 = str2;

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str2 == str3);
        // == 的基本类型比较
        System.out.println(str1 == str4);
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str2.equals(str3));
        Integer num=3;
        int num2=3;
        System.out.println(num==num2);
        // 自动拆箱，对num白亮==变量调用了intValue()方法
        System.out.println(num.equals(num2));
        Integer a=120;
        int b=120;
        Integer c=120;
        Integer d=new Integer(120);
        System.out.println("===============");
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a==d);
        System.out.println(a.equals(d));
        Integer e = 128;
        Integer f = 128;
        System.out.println(e.equals(f));

    }
}
