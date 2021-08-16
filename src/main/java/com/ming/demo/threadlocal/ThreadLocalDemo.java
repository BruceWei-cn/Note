package com.ming.demo.threadlocal;

/**
 * @author: Ming
 * @Date: 2021/6/24 13:59
 * @Description:
 */
public class ThreadLocalDemo {

	/**
	 * 斐波那契数，也叫黄金分割数
	 * <p>当hash增量为这个数字时，好处：hash分布非常均匀</p>
	 */
	private static final int HASH_INCREMENT = 0x61c88647;

	public static void main(String[] args) {
		int hashCode = 0;
		for (int i = 0; i < 15; i++) {
			hashCode = i * HASH_INCREMENT + HASH_INCREMENT;
			// 要符合公式：hashCode & (2^n - 1)
			int bucket = hashCode & (16 - 1);
			System.out.println(i + "在桶中的位置：" + bucket);
		}
	}
}
