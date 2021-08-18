package com.ming.demo.leetcode.interview;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Ming
 * @date 2021/8/18 16:06
 * @description
 */
public class Offer46 {

	/**
	 * 把数字翻译成字符串:DP
	 */
	public static void main(String[] args) {
		int num = 1227;
		System.out.println(translateNum(num));
	}

	/**
	 * 0~25,对应 a~z
	 *
	 * <P>有点类似青蛙跳台阶题目的抽象变形</P>
	 */
	public static int translateNum(int num) {
		String str = String.valueOf(num);
		int a = 1;
		int b = 1;
		for (int i = 2; i <= str.length(); i++) {
			String s = str.substring(i - 2, i);
			int c = s.compareTo("10") >= 0 && s.compareTo("25") <= 0 ? a + b : a;
			b = a;
			a = c;
		}
		return a;
	}
}
