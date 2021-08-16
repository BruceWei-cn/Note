package com.ming.demo.bloomfilter;

import java.util.BitSet;

/**
 * @author: Ming
 * @Date: 2021/5/31 15:20
 * @Description: 手写布隆过滤器
 */
public class MyBloomFilter {

	/**
	 * 位数组的大小
	 */
	private static final int DEFAULT_SIZE = 2 << 24;

	/**
	 * 创建6个不同的哈希函数
	 */
	private static final int[] SEEDS = new int[]{3, 13, 46, 71, 91, 134};

	/**
	 * 位数组，数组中元素只能是0/1
	 */
	private BitSet bits = new BitSet(DEFAULT_SIZE);

	/**
	 * 存放包含 hash 函数的类的数组
	 */
	private SimpleHash[] func = new SimpleHash[SEEDS.length];

	/**
	 * 初始化多个包含hash函数的数组，每个类中的hash函数都不一样
	 */
	public MyBloomFilter() {
		for (int i = 0; i < SEEDS.length; i++) {
			func[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
		}
	}

	/**
	 * 添加元素到位数组
	 */
	public void add(Object value) {
		for (SimpleHash f : func) {
			bits.set(f.hash(value), true);
		}
	}

	/**
	 * 判断制定并元素是否存在与数组中
	 *
	 * @param value 元素值
	 * @return true:存在，false:不存在
	 */
	public boolean contains(Object value) {
		boolean ret = true;
		for (SimpleHash f : func) {
			ret = ret && bits.get(f.hash(value));
		}
		return ret;
	}

	/**
	 * 静态内部类，用于hash操作
	 */
	public static class SimpleHash {

		private int cap;
		private int seed;

		public SimpleHash(int cap, int seed) {
			this.cap = cap;
			this.seed = seed;
		}

		/**
		 * 计算hash值
		 */
		public int hash(Object value) {
			int h;
			// >> 右移：正数高位补0，负数，高位补1； >>>：无符号右移
			/**
			 * 1: hash = value.hashCode() ^ (hash >>> 16): 右移16位，将高位16位移入到低16位再与元hashcode做异或运算，可以将高低位二进制特征混合起来（高16位无变化，低16位改变了）
			 * 		1.1： 此种做法好处，不携带高位特征做异或运算，也可以计算出不同的槽位但是若两个hashcode很接近，高区特征差异会导致一次hash碰撞，为了减少hash碰撞要携带上高位特征
			 * 2: 对哈希表找位置理论上是 hash%length，但当长度位2的幂次则可以用 hash&(length-1) 来代替这样位于运算比算术运算更快（HashMap的做法）
			 * 3： 此处多了一个干扰因子seed，目的是为了让hash函数不一致 （业务用途）
			 */
			return (value == null) ? 0
					//       干扰因子 * length-1  &  hash
					: Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
		}
	}
}
