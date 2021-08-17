package com.ming.demo.leetcode.interview;

import java.util.Objects;

/**
 * @author Ming
 * @date 2021/8/16 17:27
 * @description
 */
public class Offer26 {


	/**
	 * 判断B是否为A的子树
	 */
	public static void main(String[] args) {
		TreeNode rootA = new TreeNode(3);
		rootA.left = new TreeNode(4);
		rootA.right = new TreeNode(5);
		rootA.left.left = new TreeNode(1);
		rootA.left.right = new TreeNode(2);

		TreeNode rootB = new TreeNode(4);
		rootB.left = new TreeNode(1);
		System.out.println(isSubStructure(rootA, rootB));
	}

	/**
	 * 对A树先序遍历
	 */
	public static boolean isSubStructure(TreeNode A, TreeNode B) {
		return
				(Objects.nonNull(A) && Objects.nonNull(B))
						&& (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
	}

	/**
	 * 判断B是否为A的子树
	 */
	private static boolean recur(TreeNode A, TreeNode B) {
		if (Objects.isNull(B)) {
			return true;
		}
		if (Objects.isNull(A) || A.val != B.val) {
			return false;
		}
		return recur(A.left, B.left) && recur(A.right, B.right);
	}
}
