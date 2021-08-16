package com.ming.demo.leetcode.interview;

import java.util.*;

public class Offer32V3 {

    /**
     * Z字形打印
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        // 先进先出
        Queue<TreeNode> queue = new LinkedList<>();
        if (Objects.nonNull(root)) {
            queue.add(root);
        }
        int count = 1;
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            // BFS:遍历每一层
            for (int size = queue.size(); size > 0; size--) {
                TreeNode node = queue.poll();
                // 偶数的下一行:左->右, 奇数的下一行:右->左
                if (count % 2 == 0)
                    list.addLast(node.val);
                else
                    list.addFirst(node.val);
                if (node.right != null)
                    queue.add(node.right);
                if (node.left != null)
                    queue.add(node.left);
            }
            count++;
            lists.add(list);
        }
        return lists;
    }
}
