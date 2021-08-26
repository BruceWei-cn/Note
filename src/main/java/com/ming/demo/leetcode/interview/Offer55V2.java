package com.ming.demo.leetcode.interview;

import java.util.Objects;
import org.junit.Test;

/**
 * @author Ming
 * @date 2021/8/26 16:34
 * @description
 */
public class Offer55V2 {

	@Test
	public void test() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
//		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
//		root.right.right.right = new TreeNode(7);
		System.out.println(isBalanced(root));
	}

	/**
	 * <P>DFS</P>
	 * 判断一棵二叉树是否为平衡二叉树
	 * <P>判定条件：若该二叉树中的任意节点的左右子树深度差不超过1，那么它就是一颗平衡二叉树</P>
	 */
	public boolean isBalanced(TreeNode root) {
		if (Objects.isNull(root)) {
			return true;
		}
		// DFS: 空间O(n),时间平均O(nlogn)最差情况满二叉树O(n^2),注意一点，平衡二叉树的所有子树也都应该满足平衡二叉树的条件
		// 1. Math.abs(dfs(root.left) - dfs(root.right)) <= 1 判断此节点下左，右两边高度差是否符合平衡二叉树
		// 2. 判断左子树的左右子树是否满足平衡二叉树
		// 3. 判断右子树的左右子树是否满足平衡二叉树
		return Math.abs(dfs(root.left) - dfs(root.right)) <= 1 && isBalanced(root.left)
				&& isBalanced(root.right);
	}

	/**
	 * 求出树的高度
	 */
	private int dfs(TreeNode root) {
		if (Objects.isNull(root)) {
			return 0;
		} else {
			return Math.max(dfs(root.left), dfs(root.right)) + 1;
		}
	}
}
