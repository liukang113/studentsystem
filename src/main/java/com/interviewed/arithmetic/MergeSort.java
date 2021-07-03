package com.interviewed.arithmetic;

/**
 * @author: rockLiu
 * @date: 2021/7/3 6:42 下午
 * @desc: 归并排序
 * <p>
 * 1.分治思想，将数组一次拆分成更小的单元，进行排序
 * 2.申请临时空间，排放最终有序的数组
 * </p>
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {10, 11, 1, 7, 5, 2};
        mergeSortArchive(arr);
    }

    private static void mergeSortArchive(int[] arr) {
        //拆分
        int mid = arr.length >> 1;
        int[] temp = new int[arr.length];

        // 指定两个起始索引位置
        int i = 0;
        int j = mid + 1;
        // 指定新空间起始位置
        int k = 0;
        // 开始比较
        while (i <= mid && j < arr.length) {
//            if (arr[i] <= arr[j]) {
//                temp[k] = arr[i];
//                i++;
//                k++;
//            } else {
//                temp[k] = arr[j];
//                j++;
//                k++;
//            }
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];

        }
        // 如果拆分的子序列中已经排好序，直接将其位置挪下来
        while (i <= mid) temp[k++] = arr[i++];
        while (j < arr.length) temp[k++] = arr[j++];

        printData(temp);
    }

    private static void printData(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("index " + i + ":" + arr[i]);
        }
    }
}
