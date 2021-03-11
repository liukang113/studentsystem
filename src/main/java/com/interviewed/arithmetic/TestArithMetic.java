package com.interviewed.arithmetic;

import com.alibaba.druid.support.json.JSONUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * ${DESCRIPTION}
 *
 * @author : liukang
 * @date :2020-09-06 22:10
 **/
public class TestArithMetic {

    @Test
    public void testMoveZeroes() {
        int[] array = {0, 1, 0, 3, 2, 4};
        moveZeroes(array);
        System.out.println(JSONUtils.toJSONString(array));
    }

    /**
     * 将数组中的0 元素移动到数组尾部，保证原来顺序
     *
     * @param array
     */
    private void moveZeroes(int[] array) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                j++;
            }
        }
    }
}
