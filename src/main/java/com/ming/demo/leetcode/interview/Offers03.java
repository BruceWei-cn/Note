package com.ming.demo.leetcode.interview;

import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Ming
 * @date 2021/8/12 11:08
 */
public class Offers03 {

	/**
	 * 题目要求：找出数组中重复的数字
	 */
	public static void main(String[] args) {
		System.out.println("find() = " + find());
		System.out.println("find2() = " + find2());
	}

	private static int find() {
		int[] nums = {2, 3, 1, 0, 2, 5};
		HashMap<Integer, Integer> map = Maps.newHashMap();
		int n = 0;
		for (int num : nums) {
			if (map.isEmpty() || map.get(num) == null) {
				map.put(num, num);
			} else {
				n = num;
				break;
			}
		}
		return n;
	}

	private static int find2() {
		int[] nums = {2, 3, 1, 0, 2, 5};
		HashSet<Integer> set = new HashSet<>();
		int n = -1;
		for (int num : nums) {
			// 利用HashSet不可以存储重复元素的特性
			if (!set.add(num)){
				n = num;
				break;
			}
		}
		return n;
	}
}
