package com.ming.demo.leetcode.interview;

import org.junit.Test;

/**
 * @author Ming
 * @date 2021/9/10 19:53
 * @description
 */
public class Offer39 {

	@Test
	public void test() {
		int[] arr = {1, 2, 3, 3, 2, 2};
		System.out.println(majorityElement(arr));
	}

	/**
	 * 求出数组中出现次数超过一半的数字（众数）
	 * <P>假设数组是非空的，并且给定的数组总是存在多数元素。</P>
	 */
	public int majorityElement(int[] nums) {
		int x = 0;
		// 摩尔投票法，因为过半的数字总是最多次出现的
		// 相同则加，不同则抵消
		int vote = 0;
		int count = 0;
		for (int num : nums) {
			if (vote == 0) {
				x = num;
			}
			// 后一个数字与前一个数字相等+1，不相等 -1
			vote = vote + (x == num ? 1 : -1);
		}
		// 判断改众数出现的次数是否超过数组长度的一半，不是则返回0
		for (int num : nums) {
			if (num == x) {
				count++;
			}
		}
		return count > nums.length / 2 ? x : 0;
	}
}
