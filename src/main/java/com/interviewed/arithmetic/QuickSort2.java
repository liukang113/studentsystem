package com.interviewed.arithmetic;

/**
 * @author: rockLiu
 * @date: 2021/7/2 10:49 下午
 * @desc:
 */
public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr = {2, 10, 1, 7, 5};
        quickSortArchive(arr, 0, arr.length - 1);
        printData(arr);
    }


    private static void quickSortArchive(int[] arr, int lef, int right) {
        if(lef>=right){
            return;
        }
        int partitionIndex = partition(arr,lef,right);

    }

    private static int partition(int[] arr, int lef, int right) {
        return 0;
    }

    private static void printData(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("index " + i + ":" + arr[i]);
        }
    }
}
