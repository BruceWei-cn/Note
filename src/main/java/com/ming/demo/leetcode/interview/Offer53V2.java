package com.ming.demo.leetcode.interview;

import java.util.HashSet;

/**
 * @author Ming
 * @date 2021/8/12 16:20
 * @description
 */
public class Offer53V2 {

	/**
	 * 从0 ~ n-1 数组中找到缺省的数字
	 */
	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 3, 4, 6, 7};
		System.out.println(findLackNum(nums));
		System.out.println(binaryFindLackNum2(nums));
	}

	private static int findLackNum(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		int count = 0;
		for (int num : nums) {
			set.add(num);
		}
		for (Integer i : set) {
			if (count != i) {
				break;
			}
			count++;
		}
		return count;
	}

	/**
	 * <P>数组下标：0,1,2,3,4,5,6</P>
	 * <P>数组内值：0,1,2,3,4,6,7</P>
	 */
	private static int binaryFindLackNum2(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			// 数组下标是从0开始连续的向n增长，若相等范围区域继续向右靠
			if (nums[mid] == mid) {
				left = mid + 1;
			}
			// 不相范围区域向左靠拢
			else {
				right = mid - 1;
			}
		}
		return left;
	}
}
