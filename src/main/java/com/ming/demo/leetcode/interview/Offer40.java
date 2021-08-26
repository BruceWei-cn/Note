package com.ming.demo.leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import org.junit.Test;

/**
 * @author Ming
 * @date 2021/8/25 14:04
 * @description
 */
public class Offer40 {

	@Test
	public void test() {
		int[] arr = {0,0,1,2,4,2,2,3,1,4};
		System.out.println(Arrays.toString(getLeastNumbers(arr, 8)));
		System.out.println(Arrays.toString(getLeastNumbers02(arr, 8)));
		System.out.println(Arrays.toString(getLeastNumbers03(arr, 8)));
	}

	/**
	 * 最小的K个数
	 */
	public int[] getLeastNumbers(int[] arr, int k) {
		List<Integer> list = new ArrayList<>();
		int[] ints = new int[k];
		int i = 0;
		Arrays.stream(arr).sorted().forEach(list::add);
		for (Integer integer : list) {
			if (k > 0) {
				ints[i] = integer;
				i++;
				k--;
			}
		}

		return ints;
	}

	public int[] getLeastNumbers02(int[] arr, int k) {
		int[] ints = new int[k];
		int i = 0;
		int[] array = Arrays.stream(arr).sorted().toArray();
		for (int num : array) {
			if (k > 0) {
				ints[i] = num;
				k--;
				i++;
			}
		}
		return ints;
	}

	/**
	 * 利用最小堆获取数组中最小的前k个数
	 */
	public int[] getLeastNumbers03(int[] arr, int k) {
		int[] ints = new int[k];
		if (k == 0)
			return ints;
		// 优先队列: 重写后保证每次从队列中取出的值是最大的值
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
		for (int i = 0; i < k; i++) {
			// 构建最大堆
			queue.add(arr[i]);
		}
		// 遍历原数组，将更小的值替换进最大堆中
		// queue会自动调整队列结构（完全二叉树），根据我上面重写Comparator将最大的值移动到二叉树的根然后poll
		for (int i = k; i < arr.length; i++) {
			if (queue.peek() > arr[i]) {
				// 将最大堆的头移除
				queue.poll();
				queue.add(arr[i]);
			}
		}
		for (int i = k - 1; i >= 0; i--) {
			ints[i] = queue.poll();
		}
		return ints;
	}

}
