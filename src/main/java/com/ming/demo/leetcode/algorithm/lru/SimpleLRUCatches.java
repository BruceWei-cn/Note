package com.ming.demo.leetcode.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * @author: Ming
 * @Date: 2021/6/21 10:21
 * @Description: 简单实现LRU算法 （手写实现需要 hash + CLH双向队列）
 */
public class SimpleLRUCatches extends LinkedHashMap<Integer, Integer> {

	private int capacity;

	public SimpleLRUCatches(){}

	/**
	 * 含参构造方法
	 */
	public SimpleLRUCatches(int capacity) {
	 //the ordering mode : true -> for access-order, false -> for insertion-order
		super(capacity, 0.75F, true);
		this.capacity = capacity;
	}

	public int get(int key) {
		// 调用父类方法，key存在则返回对应的value,b不存在则返回-1
		return super.getOrDefault(key, -1);
	}

	public void put(int key, int value) {
		super.put(key, value);
	}

	@Override
	protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
		return size() > capacity;
	}

	public static void main(String[] args) {
		SimpleLRUCatches lruCatches = new SimpleLRUCatches(3);
		lruCatches.put(1,100);
		System.out.println(lruCatches.get(1) == 100);
		lruCatches.put(2,200);
		lruCatches.put(3,300);
		// keySet -> Returns a Set view of the keys contained in this map.
		System.out.println(lruCatches.keySet());
		// 最近使用包含了 对原有值修改/插入 或者 对新的值插入
//		lruCatches.put(1,200);
		System.out.println(lruCatches.keySet());
		System.out.println(lruCatches.get(1));
		lruCatches.put(4,400);
		// 新值插入，最久未使用的值会被移除
		System.out.println(lruCatches.keySet());
	}
}
