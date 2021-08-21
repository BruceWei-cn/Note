package com.ming.demo.leetcode.interview;

import org.junit.Test;

public class Offer57 {

    @Test
    public void test() {
        int[] ints = {2, 7, 11, 15};
        for (int i : twoSum(ints, 9)) {
            System.out.println("i = " + i);
        }
    }

    /**
     * 和为s的两个数字
     */
    public int[] twoSum(int[] nums, int target) {
        // 双指针做法
        int l = 0;
        int r = nums.length - 1;
        // 利用数组有序递增
        while (l < r) {
            if ((nums[l] + nums[r]) > target) {
                r--;
            } else if ((nums[l] + nums[r]) < target) {
                l++;
            } else if ((nums[l] + nums[r] == target)) {
                break;
            }
        }
        int[] ints = {nums[l], nums[r]};
        return ints;
    }
}
