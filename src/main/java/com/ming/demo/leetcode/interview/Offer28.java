package com.ming.demo.leetcode.interview;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @author Ming
 * @date 2021/8/16 11:55
 * @description
 */
public class Offer28 {

	/**
	 * 判断二叉树是否对称
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		System.out.println(isSymmetric(root));
		System.out.println(isSymmetric02(root));
	}

	/**
	 * 判断一颗二叉树是否对称
	 * <P>!!!!利用bfs此法有误，错误解答</P>
	 */
	public static boolean isSymmetric(TreeNode root) {
		// 利用BFS,辅助队列
		LinkedList<TreeNode> queue = new LinkedList<>();
		if (Objects.nonNull(root)) {
			queue.add(root);
		}
		boolean flag = false;
		while (!queue.isEmpty()) {
			// 层序遍历
			for (int size = queue.size(); size > 0; size--) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (Objects.nonNull(node.right)) {
					queue.add(node.right);
				}
				// 判断是否对成
				if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
					flag = true;
				} else if (node.left.val != node.right.val) {
					return false;
				}
			}
		}
		return flag;
	}

	/**
	 * 利用DFS,深度优先遍历
	 */
	public static boolean isSymmetric02(TreeNode root) {
		return Objects.isNull(root) || judge(root.left, root.right);
	}

	private static boolean judge(TreeNode left, TreeNode right) {
		if (Objects.isNull(left) && Objects.isNull(right)) {
			return true;
		} else if (Objects.isNull(left) || Objects.isNull(right) || left.val != right.val) {
			return false;
		}
		return judge(left.left, right.right) && judge(left.right, right.left);
	}
}
