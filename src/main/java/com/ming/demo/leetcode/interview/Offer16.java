package com.ming.demo.leetcode.interview;

import org.junit.Test;

/**
 * @author Ming
 * @date 2021/9/30 16:53
 */
public class Offer16 {

	@Test
	public void test(){
		System.out.println(myPow(2, 9));
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
		// 用来统计总数
		double res = 1.0;
		if (b < 0) {
			x = 1 / x;
			b = -b;
		}
		while (b > 0) {
			// 举例：9=1001 -> 2^9=2^(1*2^3)*2^(0*2^2)*2^(0*2^1)*2^(1*2^0) = 2^8*1*1*2
			// 解释当b的最后一位为0时，此时的值为1不计入统计数字
			if ((b & 1) == 1) {
				res *= x;
			}
			// x=x^2其中x的基数是会随着计算而变动的
			x *= x;
			// 利用幂次方的特性，将其转换为一个一个数单独相乘；幂次方的二进制右移一位
			b >>= 1;
		}
		return res;
	}
}
