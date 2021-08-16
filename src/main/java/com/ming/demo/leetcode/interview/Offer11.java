package com.ming.demo.leetcode.interview;

/**
 * @author Ming
 * @date 2021/8/13 14:05
 * @description
 */
public class Offer11 {

	/**
	 * 旋转数组的最小数字
	 */
	public static void main(String[] args) {
		int[] ints = {3, 1, 1};
		System.out.println(find(ints));
		System.out.println(find2(ints));
	}

	/**
	 * 未使用二分 时间复杂度O(n)
	 */
	private static int find(int[] ints) {
		int count = ints[0];
		for (int i = 0; i <= ints.length - 1; i++) {
			// 向右寻找
			if (i > 0 && ints[i - 1] > ints[i]) {
				count = ints[i];
				break;
			}
		}
		return count;
	}

	/**
	 * 使用二分查找
	 */
	private static int find2(int[] ints) {
		int left = 0;
		int right = ints.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (ints[mid] < ints[right]) {
				// 范围向左侧靠拢
				right = mid;
			} else if (ints[mid] > ints[right]) {
				// 范围向右侧靠拢
				left = mid + 1;
			}
			// 不符合以上两点，说明 从mid到数组末尾都的值大小都相同，那么范围需向左靠拢
			else {
				right --;
			}
		}
		return ints[left];
	}
}
