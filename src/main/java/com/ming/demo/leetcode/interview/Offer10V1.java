package com.ming.demo.leetcode.interview;

/**
 * @author Ming
 * @date 2021/8/16 14:30
 * @description
 */
public class Offer10V1 {

	/**
	 * 斐波那契数列
	 */
	public static void main(String[] args) {
		System.out.println(fib(5));
		System.out.println(fib02(5));
	}

	/**
	 * 利用DP来做
	 */
	public static int fib(int n) {
		if (n < 2) {
			return n;
		}
		int pre1 = 1;
		int pre2 = 0;
		int sum = -1;
		for (int i = 2; i <= n; i++) {
			// 1000000007 是最小的十位质数。模1000000007，可以保证值永远在int的范围内。
			sum = (pre1 + pre2) % 1000000007;
			pre2 = pre1;
			pre1 = sum;
		}
		return sum;
	}

	/**
	 * 使用递归方式，时间空间O(n)
	 */
	public static int fib02(int n) {
		// 终止条件
		if (n < 2) {
			return n;
		}
		// 递归公式，上下层级关系
		return (fib(n - 1) + fib(n - 2)) % 1000000007;
	}
}
