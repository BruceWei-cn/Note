package com.ming.demo.leetcode.interview;

import org.junit.Test;

public class Number189 {

    @Test
    public void test() {
        int[] nums = {-1};
        rotate(nums, 2);
    }

    /**
     * 旋转数组
     * <P>给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。</P>
     * <P>利用数组的反转来做</P>
     * <P>理解：nums = "----->-->"; k =3
     * result = "-->----->";
     * <p>
     * reverse "----->-->" we can get "<--<-----"
     * reverse "<--" we can get "--><-----"
     * reverse "<-----" we can get "-->----->"</P>
     */
    public void rotate(int[] nums, int k) {
        // 求余运算 2%1 = 0 余数为0
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 将给定的数组的 l~r区间反转
     *
     * @param nums 数组
     * @param l    反转区间左侧
     * @param r    反转区间右侧
     */
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            // 左侧右移
            ++l;
            // 右侧左移动
            --r;
        }
    }
}
