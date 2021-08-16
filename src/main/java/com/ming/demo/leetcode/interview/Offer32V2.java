package com.ming.demo.leetcode.interview;

import java.util.*;

public class Offer32V2 {

    /**
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
        /*for (int i : Offer32V1.levelOrder(root)) {
            System.out.print("i = " + i);
        }*/
        System.out.println(Offer32V3.levelOrder(root));
    }

    /**
     * 从上之下一层一层打印,称之为广度优先搜索,BFS;可以借助队列的先进先出特性来做
     */
    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        // 使用队列先进先出的特性
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            // 先将根节点加入队列
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            // 每一层遍历一遍
            // size会随着赋值初始化一遍,即使过程中queue的size变化得等到此次循环结束后重新赋值
            for (int size = queue.size(); size > 0; size--) {
                // 获取每个子TreeNode
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            lists.add(tmp);
        }
        return lists;
    }
}
