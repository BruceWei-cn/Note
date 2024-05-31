package com.ming.demo.leetcode.algorithm.sort;

import java.util.Objects;

/**
 * @author Ming
 * @date 31/5/2024-下午 3:38
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] ints = new int[6];
        ints[0] = 4;
        ints[1] = 2;
        ints[2] = 5;
        ints[3] = 1;
        ints[4] = 6;
        ints[5] = 3;
        insertionSort(ints);
    }

    /**
     * 插入排序
     *
     * @param a
     */
    public static void insertionSort(int[] a) {
        if (Objects.isNull(a) || a.length == 0) {
            return;
        }

        for (int i = 1; i < a.length; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    // 大的数据向右移动
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            // 小的数据向前插入
            a[j + 1] = value;
        }
    }
}
