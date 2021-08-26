package com.ming.demo.leetcode.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import org.junit.Test;

/**
 * @author Ming
 * @date 2021/8/26 15:54
 * @description
 */
public class Offer55 {

	/**
	 * 搜索与回溯
	 */
	@Test
	public void test() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(maxDepth(root));
		System.out.println(maxDepth02(root));
	}

	/**
	 * 二叉树的深度,利用DFS
	 */
	public int maxDepth(TreeNode root) {
		if (Objects.isNull(root)) {
			return 0;
		}
		return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
	}

	/**
	 * 利用BFS
	 */
	public int maxDepth02(TreeNode root) {
		if (Objects.isNull(root)) {
			return 0;
		}
		// 利用队列先进先出特性
		List<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int count = 0;
		// 层序遍历
		while (!queue.isEmpty()) {
			// 动态变量，只保存当前层的树节点
			ArrayList<TreeNode> list = new ArrayList<>();
			for (TreeNode node : queue) {
				if (Objects.nonNull(node.left)) {
					list.add(node.left);
				}
				if (Objects.nonNull(node.right)) {
					list.add(node.right);
				}
			}
			queue = list;
			// 同一高度，累加一次
			count++;
		}
		return count;
	}
}
