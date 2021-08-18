package com.ming.demo.leetcode.interview;

import java.util.HashSet;

/**
 * @author Ming
 * @date 2021/8/12 10:32
 * @description
 */
public class Number03 {

    /**
     * 给定字符串，找出其内无重复字符的最大长度
     */
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 线性遍历,滑动窗口
     */
    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s)){
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int j = 0;
        int ans = Integer.MIN_VALUE;
        // 大循环
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            // 小循环,指针走在大循环;每次遇到重复肯定是第一个字符与将要加入的字符重复了,
            // 此时跳出小循环,将大循环向前移动一格,相当于移除小循环的第一个字符;
            while (j < s.length() && !set.contains(s.charAt(j))) {
                //没遇到重复的不断地向右移动
                set.add(s.charAt(j));
                ++j;
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}
