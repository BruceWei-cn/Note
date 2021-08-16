package com.ming.demo.conding.interview;

import java.util.*;

public class Offer27 {

    /***
     * 镜像二叉树
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
      /*  root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(mirrorTree(root));*/
        System.out.println(mirrorTree02(root));
    }

    /**
     * DFS: Deep first Search 递归
     */
    public static TreeNode mirrorTree(TreeNode root) {
        // 递归的终止条件
        if (Objects.isNull(root))
            return null;
        // 递归公式, 左右交换
        TreeNode right = mirrorTree(root.right);
        TreeNode left = mirrorTree(root.left);
        root.right = left;
        root.left = right;
        return root;
    }

    /**
     * 使用栈
     */
    public static TreeNode mirrorTree02(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        if (Objects.nonNull(root)) {
            stack.push(root);
        }else {
            return null;
        }
        // 使用栈改变树结构
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (Objects.nonNull(node.left))
                stack.push(node.left);
            if (Objects.nonNull(node.right))
                stack.push(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}
