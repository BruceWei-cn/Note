package com.ming.demo.leetcode.interview;

import java.util.HashSet;

/**
 * @author Ming
 * @date 2021/8/18 18:04
 * @description
 */
public class Offer48 {

    /**
     * 最长不含重复字符的字符串
     */
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 方法一:使用滑动窗口
     */
    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int j = 0;
        HashSet<Character> set = new HashSet<>();
        // 两个指针同时从字符串最左侧向右以不同条件滑动
        // 指针1: 当指针二遇到遇到了重复字符,将最set第一位重复的字符去除,指针1向左
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            // 指针二:在没遇到重复的字符之前一直向左移动
            while (j < s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                ++j;
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}
