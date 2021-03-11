package com.interviewed.arithmetic;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2019/1/31 11:50
 * Description:
 */
public class QuickSort {

    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] a = {12, 20, 5, 16, 15, 1, 30, 45, 23, 9};
        int start = 0;
        int end = a.length - 1;
        quickFast(a, start, end);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void quickFast(int[] arr, int low, int high) {
        int start = low;
        int end = high;
        // 关键比对值
        int key = arr[start];
        while (end > start) {
            // 第一步 ：从后往前比较(找出比关键值小的元素)
            while (end > start && arr[end] >= key) {
                end--;
            }
            if (arr[end] < key) {
                // 互换位置
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            // 第二步，从前往后找(找出比关键值大的元素)
            while (start < end && arr[start] <= key) {
                start++;
            }
            if (arr[start] > key) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }

        }
        //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        if (start > low) { quickFast(arr, low, start - 1); }
        if (end < high) { quickFast(arr, end + 1, high);}
        // 上面最后一句不是基准值的意思是，不是直接用基准值交换，是用基准值所在的索引交换。
    }
}