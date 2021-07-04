package com.interviewed.arithmetic;

/**
 * @author: rockLiu
 * @date: 2021/7/2 10:49 下午
 * @desc:
 */
public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr = {2, 10, 1, 7, 5, 2, 4, 3, 8, 7, 9, 6, 6};
        sort(arr, 0, arr.length - 1);
        printData(arr);
    }


    private static void sort(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return;
        }
        int partitionIndex = partition(arr, leftBound, rightBound);
        sort(arr, leftBound, partitionIndex - 1);
        sort(arr, partitionIndex + 1, rightBound);

    }

    /**
     * 查找轴所在位置
     *
     * @param arr
     * @param leftBound
     * @param rightBound
     * @return
     */
    private static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;
        while (left < right) {
            while (left <= right && arr[left] <= pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            if (left < right) {
                swapData(arr, left, right);
            }
        }

        swapData(arr, left, rightBound);
        return left;
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
