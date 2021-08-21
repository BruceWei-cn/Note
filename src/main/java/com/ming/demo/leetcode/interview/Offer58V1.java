package com.ming.demo.leetcode.interview;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class Offer58V1 {

    @Test
    public void test() {
        String str = " the sky is  blue";
        System.out.println(reverseWords(str));
        System.out.println(reverseWords02(str));
    }

    /**
     * the require as the name
     * <P>时间/空间复杂度O(n)</P>
     */
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (StringUtils.isNotBlank(split[i])) {
                builder.append(split[i]);
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    public String reverseWords02(String s) {
        String[] split = s.trim().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].length() != 0) {
                builder.append(split[i]);
                builder.append(" ");
            }
        }
        // 去除首位空格
        return builder.toString().trim();
    }
}
