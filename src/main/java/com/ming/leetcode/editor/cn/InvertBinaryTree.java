package com.ming.leetcode.editor.cn;

//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,3]
//输出：[2,3,1]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1825 👎 0


import java.util.Objects;

public class InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
        TreeNode treeNode = new TreeNode();
        treeNode.setVal(3);
        TreeNode rightNode = new TreeNode();
        rightNode.setVal(2);
        TreeNode leftNode = new TreeNode();
        leftNode.setVal(1);
        treeNode.setRight(rightNode);
        treeNode.setLeft(leftNode);
        solution.invertTree(treeNode);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (Objects.isNull(root)) {
                return null;
            }
            // DFS
            TreeNode leftNode = invertTree(root.left);
            TreeNode rightNode = invertTree(root.right);
            root.left = rightNode;
            root.right = leftNode;
            // 子节点
            return root;
            // 二叉数，空间复杂度O(log N)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}