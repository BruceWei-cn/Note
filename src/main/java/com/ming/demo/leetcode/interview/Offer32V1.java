package com.ming.demo.leetcode.interview;

import java.util.*;

public class Offer32V1 {

    /**
     * BFS
     */
    public static int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (Objects.nonNull(root)) {
            queue.add(root);
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
