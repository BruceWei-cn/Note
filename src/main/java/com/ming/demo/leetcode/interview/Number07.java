package com.ming.demo.leetcode.interview;

import org.junit.Test;

/**
 * 整数反转
 *
 * @author Ming
 * @date 2021/9/26 17:06
 */
public class Number07 {

	@Test
	public void test() {
		System.out.println(reverse(123));
	}

	/**
	 * 反转数字，采用取模，取整的方式
	 * <P>给定范围：-2^31 <= x <= 2^31 - 1</P>
	 */
	public int reverse(int x) {
		if (x == 0) {
			return 0;
		}
		int y = 0;
		while (x != 0) {
			// 重点判断条件，超过边界会溢出
			if (Integer.MIN_VALUE / 10 > y || y > Integer.MAX_VALUE / 10) {
				return 0;
			}
			y = y * 10 + x % 10;
			x = x / 10;
		}
		return y;
	}
}
