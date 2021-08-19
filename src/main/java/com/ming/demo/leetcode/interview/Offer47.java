package com.ming.demo.leetcode.interview;

/**
 * @author Ming
 * @date 2021/8/17 15:27
 * @description
 */
public class Offer47 {

	/**
	 * 礼物的最大价值
	 */
	public static void main(String[] args) {

	}

	public int maxValue(int[][] grid) {
		// 行数
		int m = grid.length;
		// 列数
		int n = grid[0].length;
		// 因为只能向右或向下走，
		for (int i = 1; i < m; i++) {
			// 第一列的每一行
			grid[i][0] += grid[i - 1][0];
		}
		for (int j = 1; j < n; j++) {
			// 第一行的每一列
			grid[0][j] += grid[0][j - 1];
		}
		for(int i = 1; i < m; i++)
			for(int j = 1; j < n; j++)
				// 判断向右或是向下
				grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
		return grid[m - 1][n - 1];
	}
}
