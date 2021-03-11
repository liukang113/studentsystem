package com.interviewed.execption;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ${DESCRIPTION}
 *
 * @author : liukang
 * @date :2019-08-13 15:11
 **/
public class Test2 {
    public static void main(String[] args) {
        int res = getProcess();
        System.out.println(res);

    }

    private static int getProcess() {
        Scanner in = new Scanner(System.in);
        int data = 10;
        System.out.println("请输入被除数：");
        try {
            int num1 = in.nextInt();
            System.out.println("接受除数");
            int num2 = in.nextInt();
            System.out.println(num1 + "/" + num2 + "=" + num1 / num2);
            return data;
        } catch (InputMismatchException e) {//try中有匹配的异常，异常后的语句均不执行，直接调用catch，然后执行catch块之后的程序，若有异常但不匹配，不执行catch块，程序直接结束
            System.out.println("出现错误，被除数和除数必须为整数");
            e.getMessage();
        } catch (ArithmeticException e) {
            System.out.println("被除数不可为0");
            e.printStackTrace();
        } finally {//无论是否发生异常，异常是否匹配，都会执行finally,若catch调用System.exit(1);finally与finally之后语句均不执行
            System.out.println("感谢使用");
            data = 30;
            System.out.println("最终结果={}" + data);
        }
        System.out.println("finally之后语句");
        System.out.println("最终结果={}" + data);
        return data;
    }
}
