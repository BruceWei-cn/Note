package com.ming.demo.leetcode.interview;

import java.util.HashMap;

/**
 * @author Ming
 * @date 2021/8/12 11:44
 * @description
 */
public class Offer53V1 {

	/**
	 * 统计一个数字在排序数组中出现的次数
	 */
	public static void main(String[] args) {
		int[] nums = {5, 6, 6, 8, 8, 8, 10};
		int target = 10;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.merge(num, 1, Integer::sum);
		}
		System.out.println(map.get(target) == null ? 0 : map.get(target));

		System.out.println(binarySearch(nums, target) - binarySearch(nums, target - 1));
	}

	/**
	 * 利用二分查找,寻找目标元素的左右下标
	 * <P>简单说明：我需要找到最后一个8后面一个元素的下标，以及第一个8出现的下标，相减得到元素个数长度</P>
	 */
	private static int binarySearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		// 搜索边界
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] <= target) {
				// 左指针继续向右移动
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}
}
