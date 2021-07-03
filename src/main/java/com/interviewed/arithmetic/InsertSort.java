package com.interviewed.arithmetic;

/**
 * @date: 2021/7/3 4:26 下午
 * @author: rockLiu
 * @desc: 插入排序
 * <p>
 * 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 * 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {10, 11, 1, 7, 5, 2};
        insertSortArchive(arr);
        printData(arr);
    }

    private static void insertSortArchive(int[] arr) {
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swapData(arr, j, j - 1);
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
