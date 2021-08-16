package com.ming.demo.conding.interview;

/**
 * @author Ming
 * @date 2021/8/11 11:00
 * @description
 */
public class Offer58 {

	/**
	 * 左旋字符串
	 */
	public static void main(String[] args) {
		String s = "qwerty";
		int k = 2;
		StringBuilder builder = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			builder.append(s.charAt(i));
		}
		for (int i = k; i < s.length(); i++) {
			sb.append(s.charAt(i));
		}
		System.out.println(sb.append(builder));

		// 方法二
		StringBuilder str = new StringBuilder();
		StringBuilder str1 = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (i < k) {
				str1.append(s.charAt(i));
			} else {
				str.append(s.charAt(i));
			}
		}
		System.out.println(str.append(str1));

		// 方法三 [,)
		System.out.println(s.substring(k) + s.substring(0, k));
	}
}
