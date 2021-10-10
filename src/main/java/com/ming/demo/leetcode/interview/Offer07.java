package com.ming.demo.leetcode.interview;

import java.util.HashMap;

/**
 * @author Ming
 * @date 2021/10/9 17:10
 */
public class Offer07 {

    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();


    /**
     * 重建二叉树
     * <p>题目要求：输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
     * <p>
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。</p>
     */
    class Solution {
        int[] preorder;
        HashMap<Integer, Integer> dic = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            for (int i = 0; i < inorder.length; i++)
                dic.put(inorder[i], i);
            return recur(0, 0, inorder.length - 1);
        }

        TreeNode recur(int root, int left, int right) {
            if (left > right) return null;                          // 递归终止
            TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
            int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
            node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
            node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
            return node;                                           // 回溯返回根节点
        }
    }
}
