package com.ming.demo.leetcode.interview;

import org.junit.Test;

/**
 * @author Ming
 * @date 2021/9/8 15:52
 * @description
 */
public class Offer65 {

	@Test
	public void test(){
		System.out.println(add(1, 1));
	}

	/**
	 * 不用加减乘除做加法
	 */
	public int add(int a, int b) {
		while (b != 0) {
			int c = (a & b) << 1;
			a = a ^ b;
			b = c;
		}
		return a;
	}
}
