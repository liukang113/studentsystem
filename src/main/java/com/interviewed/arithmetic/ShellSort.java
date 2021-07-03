package com.interviewed.arithmetic;

/**
 * @author: rockLiu
 * @date: 2021/7/3 5:44 下午
 * @desc:
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {10, 11, 1, 7, 5, 2};
        shellSortArchive(arr);
        printData(arr);
    }

    private static void shellSortArchive(int[] arr) {
        // 计算间隔  Knuth间隔算法
//        int h = 1;
//        while (h <= arr.length / 3) {
//            h = h * 3 + 1;
//        }


        for (int gap = arr.length >> 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        swapData(arr, j, j - gap);
                    }
                }
            }
        }

    }

    private static void swapData(int[] arr, int i, int min) {
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }

    private static void printData(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("index " + i + ":" + arr[i]);
        }
    }
}
