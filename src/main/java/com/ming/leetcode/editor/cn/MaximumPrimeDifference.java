package com.ming.leetcode.editor.cn;

//给你一个整数数组 nums。
//
// 返回两个（不一定不同的）质数在 nums 中 下标 的 最大距离。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [4,2,9,5,3] 
// 
//
// 输出： 3 
//
// 解释： nums[1]、nums[3] 和 nums[4] 是质数。因此答案是 |4 - 1| = 3。 
//
// 示例 2： 
//
// 
// 输入： nums = [4,8,2,8] 
// 
//
// 输出： 0 
//
// 解释： nums[2] 是质数。因为只有一个质数，所以答案是 |2 - 2| = 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁵ 
// 1 <= nums[i] <= 100 
// 输入保证 nums 中至少有一个质数。 
// 
//
// Related Topics 数组 数学 数论 👍 17 👎 0


import java.util.Objects;

public class MaximumPrimeDifference {
    public static void main(String[] args) {
        Solution solution = new MaximumPrimeDifference().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumPrimeDifference(int[] nums) {
            if (Objects.isNull(nums)) {
                return 0;
            }
            int min = -1;
            int max = -1;
            // 质数是除了它本身和1其它任何数都无法整除的数
            for (int i = 0; i < nums.length; i++) {
                if (isPrime(nums[i])) {
                    if (min < 0) {
                        min = i;
                    } else {
                        max = Math.max(max, i);
                    }
                }
            }
            return Math.max(max - min, 0);
        }

        /**
         * @param num
         * @return true:代表是质数
         */
        public boolean isPrime(int num) {
            if (num <= 1) {
                return false;
            } else if (num <= 3) {
                return true;
            }
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}