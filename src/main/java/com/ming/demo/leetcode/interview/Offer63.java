package com.ming.demo.leetcode.interview;

/**
 * @author Ming
 * @date 2021/8/16 15:31
 * @description
 */
public class Offer63 {

	/**
	 * 股票的最大利润
	 */
	public static void main(String[] args) {
		int[] nums = {7, 6, 4, 3, 1, 8};
		System.out.println(maxProfit(nums));
		System.out.println(maxProfit02(nums));
	}

	/**
	 * 使用暴力法，时间复杂度O(n^2),空间复杂度O(1)
	 */
	public static int maxProfit(int[] prices) {
		int max = 0;
		int pd = 0;
		for (int i = 0; i < prices.length; i++) {
			// 只可向第i位之后遍历
			for (int j = i + 1; j < prices.length; j++) {
				pd = prices[j] - prices[i];
				if (pd > max) {
					max = pd;
				}
			}
		}
		return max;
	}

	/**
	 * 计算最大利润可用DP来做；
	 * <P>时间复杂度O(n)遍历整个数组，空间复杂度O(1)</P>
	 */
	public static int maxProfit02(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int profit = 0;
		for (int price : prices) {
			// 获取最小值
			minPrice = Math.min(minPrice, price);
			// 获取最大利润 = max先前的利润，此次利润 =（此次的价格-最小价格））
			profit = Math.max(profit, price - minPrice);
		}
		return profit;
	}
}
