package com.ming.demo.leetcode.interview;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author Ming
 * @date 2021/9/8 11:07
 * @description
 */
public class Offer56V1 {

	@Test
	public void test() {
		int[] nums = {4, 1, 3, 4};
		System.out.println("singleNumbers(nums) = " + Arrays.toString(singleNumbers(nums)));
	}

	/**
	 * 整型数组，找出此数组内只出现一次的数字
	 * <P>要求：时间复杂度O(n),空间复杂度O(1)</P>
	 */
	public int[] singleNumbers(int[] nums) {
		int x = 0;
		// 1. 遍历 nums 执行异或运算
		for (int num : nums) {
			// 与0异或，值还是本身；相同值异或得到0
			x = x ^ num;
		}
		int m = 1;
		// 目的是为了找出x的二进制书中，第一个为1是在二进制中的第几位
		// 找到x的二进制中第一个不为1的位置并将其赋值给m,是因为这个位置是保留了数组内两位不重复数字的位置特性，
		// 		即：一个数的此位置一定为1,另一个数的此位置一定为0；以确保接下来的分组，两个不重复的数字不会被分到同一组；
		while ((x & m) == 0) {
			m <<= 1;
		}
		int i = 0,
				j = 0;
		for (int num : nums) {
			// 根据m做与运算，此方法是将一样的数字放入一组，同时确保不一样的数字一定不在同一组内
			if ((num & m) == 0) {
				i = i ^ num;
			} else {
				j = j ^ num;
			}
		}
		return new int[]{i, j};
	}
}
