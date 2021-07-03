package com.interviewed.arithmetic;

/**
 * @author: rockLiu
 * @date: 2021/7/3 3:41 下午
 * @desc: 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2, 10, 1, 7, 5};
        bubbleSortArchive(arr);
        printData(arr);
    }

    private static void bubbleSortArchive(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swapData(arr, i, j);
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
