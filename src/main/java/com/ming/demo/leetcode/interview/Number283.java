package com.ming.demo.leetcode.interview;

import org.junit.Test;

public class Number283 {

    @Test
    public void test(){
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }

    /**
     * 移动零
     * <P>题目要求：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。</P>
     * <P>利用双指针</P>
     */
    public void moveZeroes(int[] nums) {
        int l = 0, r = 0;
        // 右指针向右移动，将不为0的与左指针交换
        while (r < nums.length) {
            // 当有不为0的进行交换后，左指针才向右移动
            if (nums[r] != 0) {
                swap(nums, l, r);
                l++;
            }
            // 右指针不断向右移动
            r++;
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
