package com.back;


import java.util.Scanner;

/**
 * 〈功能简述〉<br>
 *
 * @author : liukang
 * @version : 1.0
 * @date :2020-09-21 21:06
 * @since : 1.0
 **/
public class Main {

    /**
     * 标志位
     */
    public static final int FLAG_NUM = 2;

    /**
     * 输出所有勾股数
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        while (in.hasNextInt()) {
            int startNum = in.nextInt();
            int endNum = in.nextInt();

            if (startNum < 0 || endNum < 0 || endNum < startNum || endNum - startNum < FLAG_NUM) {
                return;
            }

            for (int m = startNum; m < endNum - FLAG_NUM; m++) {
                for (int n = m + 1; n < endNum - 1; n++) {
                    // 计算平方总和
                    int sum = m * m + n * n;
                    // 完整开平方
                    int destNum = (int) Math.sqrt(sum);
                    if (startNum < destNum && destNum < endNum && destNum * destNum == sum) {
                        if (judgeHuzhi(startNum, destNum) && judgeHuzhi(startNum, endNum)) {
                            System.out.println(m + " ," + n + ", " + destNum);
                        }
                    } else {
                        System.out.println("NA");
                    }


                }
            }
        }
    }

    /**
     * 判断是否是质数
     *
     * @param m
     * @param n
     * @return
     */
    public static boolean judgeHuzhi(int m, int n) {

        int flag;
        // 可以整除
        while ((flag = m % n) != 0) {
            m = n;
            n = flag;
        }
        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }


}
