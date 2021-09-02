package com.ming.demo.leetcode.interview;

import java.util.Objects;

public class Offer68V2 {

    /**
     * 无序二叉树，找最近的公共祖先
     * <P>DFS,使用先序遍历</P>
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) return null;
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
