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
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        }
        System.out.println(ans);
    }

}
