package com.ming.demo.leetcode.algorithm.topk;

import java.util.Arrays;
import java.util.PriorityQueue;
import org.junit.Test;

/**
 * @author Ming
 * @date 2021/10/11 13:59
 * @description
 */
public class TopkTest {

	/**
	 * 题目描述：有 20 个数组，每个数组有 500 个元素，并且有序排列。如何在这 20*500 个数中找出前 500 的数？
	 * <P>假设数组降序排序，可以利用最大堆来做</P>
	 * link:https://doocs.github.io/advanced-java/#/./docs/big-data/find-rank-top-500-numbers
	 */
	public static int[] getTop(int[][] data) {
		int rowSize = data.length;
		int columnSize = data[0].length;

		// 创建一个columnSize大小的数组，存放结果
		int[] result = new int[columnSize];

		PriorityQueue<DataWithSource> maxHeap = new PriorityQueue<>();
		for (int i = 0; i < rowSize; ++i) {
			// 将每个数组的最大一个元素放入堆中
			DataWithSource d = new DataWithSource(data[i][0], i, 0);
			maxHeap.add(d);
		}

		int num = 0;
		// 只获取最大堆的前columnSize个元素组成result数组
		while (num < columnSize) {
			// 当前堆顶元素出堆
			DataWithSource d = maxHeap.poll();
			result[num++] = d.getValue();
			if (num >= columnSize) {
				break;
			}
			// 当前最大堆出队的的原始数组后一位，加入最大堆
			d.setValue(data[d.getSource()][d.getIndex() + 1]);
			d.setIndex(d.getIndex() + 1);
			maxHeap.add(d);
		}
		return result;
	}

	@Test
	public void test(){
		int[][] data = {
				{29, 17, 14, 2, 1},
				{19, 17, 16, 15, 6},
				{30, 25, 20, 14, 5},
		};

		int[] top = getTop(data);
		System.out.println(Arrays.toString(top)); // [30, 29, 25, 20, 19]
	}
}
