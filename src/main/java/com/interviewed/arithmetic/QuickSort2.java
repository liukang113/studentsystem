package com.interviewed.arithmetic;

/**
 * @author: rockLiu
 * @date: 2021/7/2 10:49 下午
 * @desc:
 */
public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr = {2, 10, 1, 7, 5};
        quickSortArchive(arr);
        printData(arr);
    }



    private static void quickSortArchive(int[] arr) {
        
    }

    private static void printData(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("index " + i + ":" + arr[i]);
        }
    }
}
