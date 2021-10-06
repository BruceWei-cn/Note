package com.ming.demo.leetcode.interview;

import org.junit.Test;

public class Number977 {

    @Test
    public void test(){
        int[] nums = {-1,2,5};
        for (int i : sortedSquares(nums)) {
            System.out.print(i);
        }
    }


    /**
     * 题目要求：给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     * <P>利用双指针</P>
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
            // 因为原給的数组也是有序的，所以可进行比较
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                arr[pos] = nums[i] * nums[i];
                ++i;
            } else {
                arr[pos] = nums[j] * nums[j];
                --j;
            }
            pos--;
        }
        return arr;
    }
}
