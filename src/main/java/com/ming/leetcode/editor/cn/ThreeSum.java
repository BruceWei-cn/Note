package com.ming.leetcode.editor.cn;

//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j !=
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 6965 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            int length = nums.length;
            // 排序复杂度log(n)
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();

            // first为起始元素
            for (int first = 0; first < length; first++) {
                // 数组排序后， first向后便利，相同元素的可以跳过
                if (first >= 1 && nums[first] == nums[first - 1]) {
                    continue;
                }

                // 指针third
                int third = length - 1;
                // nums[second] + nums[third] == target
                int target = -nums[first];

                // 元素second作为左侧指针（但在first右边）
                for (int second = first + 1; second < length; second++) {
                    // 同样元素跳过
                    if (second > first + 1 && nums[second] == nums[second - 1]) {
                        continue;
                    }
                    // 有序数组，third在最右边最大，若是相加大于目标值则需要向左移动找值
                    while (second < third && nums[second] + nums[third] > target) {
                        third--;
                    }
                    // 不符合条件跳出
                    if (second == third) {
                        break;
                    }

                    if (nums[second] + nums[third] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        result.add(list);
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}