package com.ming.demo.leetcode.interview;

import org.junit.Test;

public class Number35 {

    @Test
    public void test() {
        int[] nums = {1, 2, 4, 5};
        System.out.println(searchInsert(nums, 0));
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * <P>请必须使用时间复杂度为 O(log n) 的算法。<P/>
     */
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int ans = nums.length;
        // 考虑到最左侧边界0
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
                // 目标值不存在，则插入在仅小于target的mid的位置
                ans = mid;
            }
        }
        return ans;
    }
}
