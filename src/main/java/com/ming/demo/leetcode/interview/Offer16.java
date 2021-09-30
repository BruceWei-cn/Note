package com.ming.demo.leetcode.interview;

import org.junit.Test;

/**
 * @author Ming
 * @date 2021/9/30 16:53
 */
public class Offer16 {

	@Test
	public void test(){
		System.out.println(myPow(2, 3));
	}
	/**
	 * 数值的整数次方
	 * <P>不得使用函数库</P>
	 */
	public double myPow(double x, int n) {
		if (x == 0) {
			return 0;
		}
		long b = n;
		double res = 1.0;
		if (b < 0) {
			x = 1 / x;
			b = -b;
		}
		while (b > 0) {
			if ((b & 1) == 1) {
				res *= x;
			}
			x *= x;
			b >>= 1;
		}
		return res;
	}
}
