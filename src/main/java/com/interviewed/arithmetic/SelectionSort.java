package com.interviewed.arithmetic;


/**
 * @author: rockLiu
 * @date: 2021/7/2 10:23 下午
 * @desc: 选择算法
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2, 10, 1, 7, 5};
        selectSort(arr);
        printData(arr);
    }



    private static void selectSort(int[] arr) {
        // 选择最小的边界，依次比较，然后交换最小值得位置
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 交换位置
                    min = j;
                }
            }
            swapData(arr, i, min);
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
