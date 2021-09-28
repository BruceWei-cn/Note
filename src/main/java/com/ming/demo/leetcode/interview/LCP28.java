package com.ming.demo.leetcode.interview;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * @author Ming
 * @date 2021/9/28 16:07
 */
public class LCP28 {

	@Test
	public void test() {
		int[] nums = {2, 2, 1, 9};
		System.out.println(purchasePlans(nums, 10));
		System.out.println(purchasePlans02(nums, 10));
	}

	/**
	 * 采购方案，根据预算target计算nums种两个数之和小于target的组合有多少种
	 */
	public int purchasePlans(int[] nums, int target) {
		AtomicInteger atomic = new AtomicInteger(0);
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] <= target) {
					atomic.incrementAndGet();
				}
			}
		}
		// 防整型溢出对100000007取模
		return atomic.get() % 1000000007;
	}

	/**
	 * 利用双指针来做
	 */
	public int purchasePlans02(int[] nums, int target) {
		// 先将数组自然排序
		Arrays.sort(nums);
		int l = 0;
		int r = nums.length - 1;
		int count = 0;
		while (l < r) {
			if (nums[l] + nums[r] > target) {
				r--;
			} else {
				// 因为是有序的数组，所以当左索引+右索引符合条件；那么在l~r范围内就有r-l种组合符合要求；
				count = (count + r - l) % 1000000007;
				l++;
			}
		}
		return count;
	}
}
