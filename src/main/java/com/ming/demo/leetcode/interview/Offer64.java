package com.ming.demo.leetcode.interview;

import org.junit.Test;

/**
 * @author Ming
 * @date 2021/8/27 15:45
 * @description
 */
public class Offer64 {

	@Test
	public void test() {
		System.out.println(sumNums(3));
	}

	/**
	 * 求 1+2+3+4+...+n
	 * <P>不得使用乘除或者for,id,while,else,switch,case</P>
	 * <P>利用递归：时间复杂度每层是O(1)总共是O(n),空间复杂度即为n层递归栈O(n)</P>
	 */
	public int sumNums(int n) {
		// 递归公式
		// 利用短路，当递归到n=0时开始回溯
		boolean flag = (n > 0) && (n += sumNums(n - 1)) > 0;
		return n;
	}
}
