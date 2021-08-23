package com.ming.demo.leetcode.interview;

import org.junit.Test;

public class Number79 {

    @Test
    public void test() {

    }

    /**
     * 单词搜索：DFS
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(words, board, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[] words, char[][] board, int i, int j, int k) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != words[k])
            return false;
        if (words.length - 1 == k)
            return true;
        // 剪枝
        board[i][j] = ' ';
        // 向矩阵改点的上下左右分别遍历
        boolean res = dfs(words, board, i + 1, j, k + 1) || dfs(words, board, i - 1, j, k + 1)
                || dfs(words, board, i, j + 1, k + 1) || dfs(words, board, i, j - 1, k + 1);
        board[i][j] = words[k];
        return res;
    }
}
