package com.ming.demo.leetcode.interview;

import org.junit.Test;

public class Offer13 {

    /**
     * 机器人的运动范围
     * <p>机器人每次只能移动一格</p>
     */
    @Test
    public void test() {
        System.out.println(movingCount(2, 3, 1));
    }

    /**
     * dfs:利用递归;此题就是一种图的dfs,向下/向右
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    /**
     * dfs：递归方式；类似于矩阵的遍历，从左上角开始，统计矩阵的右/下可达点
     */
    private int dfs(int i, int j, int m, int n, int k, boolean visited[][]) {
        // visited[i][j] 为true时,意味着已经到达的点不再计入统计
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || (sum(i) + sum(j)) > k)
            return 0;
        // 将可达的点设置为true
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited);
    }

    private int sum(int num) {
        int s = 0;
        while (num != 0) {
            s += num % 10;
            num = num / 10;
        }
        return s;
    }
}