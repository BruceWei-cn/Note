package com.ming.demo.leetcode.interview;

/**
 * @author Ming
 * @date 2021/8/16 14:57
 * @description
 */
public class Offer10V2 {

	public static void main(String[] args) {
		System.out.println(fib(7));
	}

	/**
	 * 青蛙跳台阶:DP
	 */
	public static int fib(int n) {
		if (n <= 2) {
			return n;
		}
		int pre1 = 2;
		int pre2 = 1;
		int sum = -1;
		for (int i = 2; i < n; i++) {
			// 1000000007 是最小的十位质数。模1000000007，可以保证值永远在int的范围内。
			sum = (pre1 + pre2) % 1000000007;
			pre2 = pre1;
			pre1 = sum;
		}
		return sum;
	}
}
