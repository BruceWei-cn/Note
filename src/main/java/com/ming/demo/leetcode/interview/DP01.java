package com.ming.demo.leetcode.interview;

import org.junit.Test;

/**
 * @author Ming
 * @date 2021/10/25 15:15
 */
public class DP01 {

	@Test
	public void test() {
		int[] g = {400, 500, 200, 300, 350};
		int[] p = {5, 5, 3, 4, 3};
//		System.out.println(getMostGold(5, 10, g, p));
		System.out.println(getGold(g, p, 10));
	}

	/**
	 * 根据传递信息-获取挖金矿数量最大值
	 *
	 * @param n 金矿数量
	 * @param w 工人数量
	 * @param g 金矿的黄金量数组
	 * @param p 金矿的用工量数组
	 * @return 最大值
	 */
	//todo: 此方法有问题，待修正
	public int getMostGold(int n, int w, int[] g, int[] p) {
		int[] preResults = new int[p.length];
		int[] results = new int[p.length];
		// 填充边界格子的值
		for (int i = 0; i < n; i++) {
			// 若人数达不到金矿最少用工数，则挖不倒任何矿 为0
			if (i < p[0]) {
				preResults[i] = 0;
			} else {
				preResults[i] = g[0];
			}
		}
		// 填充其余格子，外层循环是金矿数量，内层循环是工人数
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= w; j++) {
				if (j < p[i]) {
					results[j] = preResults[j];
				} else {
					results[j] = Math.max(preResults[j], preResults[j - p[i]] + g[i]);
				}
			}
			preResults = results;
		}
		return results[n];
	}

	/**
	 * 利用二维数组来做
	 * <P>注意：每个金矿的含量需要与每个金矿所需矿工数一一对应</P>
	 *
	 * @param golds 表示金矿含金量
	 * @param ores 表示挖矿需要人数
	 * @param manNum 表示总人数
	 */
	public int getGold(int[] golds, int[] ores, int manNum) {
		// 长度为金矿数量
		int oLen = ores.length;
		//dp[i][j] 表示有 oLen 个金矿，manNum 人数时可以获得黄金量
		int[][] dp = new int[oLen + 1][manNum + 1];
		// 外层遍历金矿个数
		for (int i = 1; i < oLen + 1; i++) {
			// 内层遍历人数
			for (int j = 1; j < manNum + 1; j++) {
				// 若当前人数少于该矿需要的矿工人数，则挖矿数量为0
				if (j < ores[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					// 该值动态记录二维数组的每一行
					int ore = ores[i - 1];
					int i2 = j - ores[i - 1];
					int dpNum = dp[i - 1][j - ores[i - 1]];
					int gold = golds[i - 1];
					// 上一行的第j列
					int preNum = dp[i - 1][j];
					dp[i][j] = Math.max(preNum, dpNum + gold);
				}
			}
		}
		return dp[oLen][manNum];
	}
}
