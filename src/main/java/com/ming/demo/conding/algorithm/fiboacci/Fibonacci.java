package com.ming.demo.conding.algorithm.fiboacci;

import org.junit.Test;

/**
 * @author: Ming
 * @Date: 2021/5/25 19:20
 * @Description: 斐波那契数列
 */
public class Fibonacci {

	/**
	 * 最不好的写法，递归 时间复杂度： O(2^n) 空间复杂度：递归栈的空间
	 */
	private int Fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return Fib(n - 1) + Fib(n - 2);
	}

	/**
	 * 优化：用到了动态规划DP 时间复杂度O(n) 空间复杂度O(1)
	 */
	@Test
	public void FibonacciTest02() {
		int n = 3;
		/*if (n <= 1) {
			return;
		}*/
		int pre2 = 0, pre1 = 1;
		int fib = 0;
		for (int i = 2; i <= n; i++) {
			fib = pre2 + pre1;
			pre2 = pre1;
			pre1 = fib;
		}
		System.out.println("fib = " + fib);
	}

	/**
	 * 同上
	 */
	@Test
	public void FibonacciTest03() {
		// n指的是第几位
		int n = 3;
		if (n == 0 || n == 1) {
			return;
		}
		int a = 0, b = 1, c = 0;
		for (int i = 2; i <= n; ++i) {
			c = a + b;
			a = b;
			b = c;
		}
		System.out.println("c = " + c);
	}

}
