package com.ming.demo.leetcode.algorithm.binarysearch;

/**
 * @author Ming
 * @date 2021/6/30 10:55
 * @description
 */
public class SearchTargetSize {

	private static final int[] NUMS = {2,2};

	/**
	 * 利用二分查找法，寻找目标数字在有序数组中出现的次数；时间复杂度O(logn)
	 */
	public static int searchSize(int[] nums, int target) {
		if (nums.length <= 0) {
			return 0;
		}
		int left = 0;
		int right = nums.length - 1;
		// 当 left > right时候，说明left指针找到target数值的最右边界跳出循环
		while (left <= right) {
			// 防止整型溢出
			int mid = left + (right - left);
			if (nums[mid] > target) {
				right = mid - 1;
			}
			// 左下标向右移动寻找有边界值，所以此处判断条件需要 “<=”
			else if (nums[mid] <= target) {
				left = mid + 1;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		int size = searchSize(NUMS, 3) - searchSize(NUMS, 2);
		System.out.println("i = " + searchSize(NUMS, 3));
		System.out.println("j = " + searchSize(NUMS, 2));
		System.out.println("目标数字在数组中出现的次数为：" + size);
	}
}
