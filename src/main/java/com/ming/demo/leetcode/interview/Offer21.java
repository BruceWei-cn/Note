package com.ming.demo.leetcode.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Offer21 {

    @Test
    public void test() {
        int[] ints = {1, 2, 3, 4};
        int[] exchange = exchange(ints);
        for (int i : exchange) {
            System.out.println("i = " + i);
        }
        for (int i : exchange02(ints)) {
            System.out.println("i = " + i);
        }

        for (int i : exchange03(ints)) {
            System.out.println("i = " + i);
        }
    }

    /**
     * 调整数组顺序使奇数位于偶数之前
     */
    public int[] exchange(int[] nums) {
        List<Integer> even = new ArrayList();
        List<Integer> odd = new ArrayList();
        for (int num : nums) {
            if (num % 2 == 0)
                even.add(num);
            else
                odd.add(num);
        }
        odd.addAll(even);
        return odd.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 利用数组下标的特性来做
     */
    public int[] exchange02(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] ints = new int[nums.length];
        for (int num : nums) {
            if (num % 2 == 0) {
                ints[right] = num;
                right--;
            } else {
                ints[left] = num;
                left++;
            }
        }
        return ints;
    }

    public int[] exchange03(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int temp = -1;
        while (left < right) {
            // 向右找到不为偶数的
            while (left < right && (nums[left] & 1) == 1) {
                left++;
            }
            // 向左找到不为奇数的
            if (left < right && (nums[right] & 1) == 0) {
                right--;
            }
            if (left<right){
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
         }
        return nums;
    }
}
