package com.ming.demo.leetcode.interview;

import org.junit.Test;

/**
 * @author Ming
 * @date 2021/9/8 15:39
 * @description
 */
public class Offer15 {

	@Test
	public void test(){
		System.out.println("hammingWeight(3) = " + hammingWeight(3));
	}

	/**
	 * 给定一个整数，求出其二进制数中1的个数
	 */
	public int hammingWeight(int n) {
//		int count = Integer.bitCount(n);
		int m = 1;
		int count = 0;
		while (n != 0) {
			count = count + (n & m);
			n >>>= 1;
		}
		return count;
	}
}
