package com.ming.demo.leetcode.interview;

import org.junit.Test;

import java.util.Arrays;

public class Offer45 {

    @Test
    public void test() {
        int[] ints = {3, 30, 34, 5, 9};
        System.out.println(minNumber(ints));
    }

    /**
     * 把数组排成最小的数
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareToIgnoreCase(y + x));
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str);
        }
        return builder.toString();
    }
}
