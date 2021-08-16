package com.ming.demo.leetcode.algorithm.binarysearch;

import org.junit.Test;

/**
 * @author: Ming
 * @Date: 2021/6/3 17:22
 * @Description: 二分查找
 */
public class BinarySearch {

	int[] nums = new int[]{-1, 0, 3, 5, 9, 12};

	/**
	 * 根据给定元素返回该元素在数组中的下表,时间复杂度 O(logn)
	 * <p>前提：数组中无重复元素且有序</p>
	 *
	 * @param nums 数组
	 * @param target 指定元素值
	 * @return 未找到返回-1
	 */
	public int myBinarySearch(int[] nums, int target) {
		// 数组下标初始值
		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			// int mid = (start + end) / 2;  -- 该种方式不可取，万一数据过大，整型会溢出
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				// 寻找到值，直接返回
				return mid;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else if (nums[mid] < target) {
				start = mid + 1;
			}
		}
		return -1;
	}

	@Test
	public void binarySearchTest() {
		int i = myBinarySearch(nums, 12);
		System.out.println("i = " + i);
	}
}
