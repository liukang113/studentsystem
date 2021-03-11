package com.interviewed.sorted;


import org.junit.Test;

import java.util.Random;

/**
 * @author: kang.liu
 * @since : 2019/3/10 6:07 PM
 */
public class HeapSorted {

    /**
     * 替换元素
     *
     * @param data 指定数组
     * @param i    位置1
     * @param j    位置2
     */
    private static void replace(float[] data, int i, int j) {
        if (i == j) {
            return;
        }
        float temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * 小根堆排序
     * 利用小根堆的性质，最终的根节点为树中节点的最小值，将最小值放在最后
     * 剩下的节点继续进行上述操作，直至倒数第二个节点，最后一个节点为最大节点无需判断
     *
     * @param data 指定数组
     * @return
     */
    public static float[] heapSort(float[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            createMindHeap(data, data.length - 1 - i);
            //每次都将最小的数字放到最后，然后用剩下的数组继续排序
            replace(data, 0, data.length - 1 - i);
//            print(data);
        }
        return data;
    }

    /**
     * 当前节点 i==0? null:(i-1)/2
     * 左孩子节点 2*i+1
     * 右孩子节点2*i+2
     * <p>
     * 创建小根堆，只保证树的根为小根堆
     *
     * @param data      指定数组
     * @param lastIndex 最后一个节点位置
     */
    private static void createMindHeap(float[] data, int lastIndex) {
        //从最后一个节点作为左节点的树开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // 记录当前节点，根据当前节点进行判断操作
            int k = i;
            // 判断左子节点是否存在，如果小于等于最大节点数则存在
            /**
             * 这里使用while循环是为了保证每个子树的根节点为小根堆
             * 如果使用if只能保证最终根为最小根
             */
            while (2 * k + 1 <= lastIndex) {
                //暂且定为最小的为左子节点
                int smallIndex = 2 * k + 1;
                if (smallIndex + 1 <= lastIndex) {
                    //如果右子节点存在，判断左右大小（不保证左右节点满足小根堆的性质，因为只需使最小节点为根节点）
                    if (data[smallIndex] > data[smallIndex + 1]) {
                        // 若右子节点值比左子节点值小，则samllIndex记录的是右子节点的值
                        smallIndex++;
                    }
                }
                if (data[k] > data[smallIndex]) {
                    // 若当前节点值比子节点最小值大，则交换2者得值，交换后将smallIndex值赋值给k
                    replace(data, k, smallIndex);
                    //标记当前节点为最小节点，继续判断此节点作为根的堆是否为小根堆
                    k = smallIndex;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 获得指定数量的最大值数组
     *
     * @param count 指定数量
     * @param data  指定数组
     * @return
     */
    public static float[] getMaxNumber(int count, float[] data) {
        float[] maxNubmerArr = new float[count];
        for (int i = 0; i < data.length; i++) {
            if (data[i] > maxNubmerArr[0]) {
                maxNubmerArr[0] = data[i];
                createMindHeap(maxNubmerArr, count - 1);
                //查看每次取得的数字
//                 print(maxNubmerArr);
            }
        }
        return maxNubmerArr;
    }

    /**
     * 输出数组
     *
     * @param data
     */
    public static void print(float[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }


    @Test
    public void test1() {
        float arr[] = new float[1000000];
        for (int i = 0; i < 1000000; i++) {
            Random random = new Random();
            float v = random.nextFloat() * 50f;
            arr[i] = v;
        }
        long start = System.currentTimeMillis();
        float[] maxNumber = HeapSorted.getMaxNumber(100, arr);
        HeapSorted.heapSort(maxNumber);
        HeapSorted.print(maxNumber);
        System.out.println(System.currentTimeMillis() - start);
    }

}
