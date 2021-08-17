package com.ming.demo.leetcode.interview;

/**
 * @author Ming
 * @date 2021/8/17 10:51
 * @description
 */
public class Offer42 {

	/**
	 * 核心： Dynamic program
	 */
	public static void main(String[] args) {
		int[] nums = {-2, 1, -3};
		System.out.println(maxSubArray(nums));
		System.out.println(maxSubArray02(nums));
		System.out.println(maxSubArray03(nums));
	}

	/**
	 * 求一个数组中某个连续子数组的最大值
	 * <P>DP思考：以数组下标连续为前提下：以第i个数组下表为例，若前i-1<=0那么前i-1个的和丢弃；否则继续与第i个相加 </P>
	 *
	 * <P>DP时间复杂度O(n),空间复杂度O(1)</P>
	 */
	public static int maxSubArray(int[] nums) {
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			// 若前nums[i-1]<=0则取值0，这里的nums[i]意思时从0-i位数的总值
			// 转移方程，核心公式
			nums[i] = nums[i] + Math.max(nums[i - 1], 0);
			// sum为子数组最大值
			sum = Math.max(nums[i], sum);
		}
		return sum;
	}

	public static int maxSubArray02(int[] nums) {
		int sum = Integer.MIN_VALUE;
		int pre = 0;
		for (int i = 0; i < nums.length; i++) {
			// 若前nums[i-1]<=0则取值0，这里的nums[i]意思时从0-i位数的总值
			// 转移方程，核心公式
			pre = Math.max(nums[i], pre + nums[i]);
			// sum为子数组最大值(将现在的值，与之前子数组计算出的最大值比较，取大)
			sum = Math.max(pre, sum);
		}
		return sum;
	}

	/**
	 * 前缀和
	 */
	public static int maxSubArray03(int[] nums) {
		int sum = 0;
		int minSum = 0;
		int dp = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			// sum为前nums[i-1]之和
			sum = sum + nums[i];
			// 转移方程
			dp = Math.max(dp, sum - minSum);
			// 获取遍历数组过程中的最小和
			minSum = Math.min(minSum, sum);
		}
		return dp;
	}
}
