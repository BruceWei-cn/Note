package com.ming.demo.conding.interview;

/**
 * @author Ming
 * @date 2021/8/11 10:32
 * @description
 */
public class Offers05 {

	/**
	 * 替换字符串内的空格为 -> %20
	 */
	public static void main(String[] args) {
		String str = "We are happy";
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == (' ')){
				builder.append("%20");
			} else {
				builder.append(c);
			}
		}
		System.out.println("builder = " + builder);
	}
}
