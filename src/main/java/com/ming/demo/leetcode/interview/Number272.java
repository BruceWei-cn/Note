package com.ming.demo.leetcode.interview;

public class Number272 {

    /**
     * 第一个错误的版本号
     * <P>利用二分查找</P>
     */
    public int firstBadVersion(int n) {
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (true) {
                // 为true说明第一个错误的版本还在左边，将右边界左移
                r = mid;
            }else {
                // 说明mid是正确的版本，第一个错误的版本在右边，将左边界向右移动
                l=mid+1;
            }
        }
        return l;
    }
}
