package com.ming.demo.leetcode.interview;

import java.util.Objects;
import org.junit.Test;

/**
 * @author Ming
 * @date 2021/8/27 16:31
 * @description
 */
public class Offer68V1 {

	@Test
	public void test() {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		System.out.println(lowestCommonAncestor(root, root.left, root.left.right));
	}

	/**
	 * 二叉搜索树的最近公共祖先
	 * <P>利用二叉树的有序的特性</P>
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (Objects.isNull(root)) {
			return null;
		}
		if (root.val > p.val && root.val > q.val) {
			root = lowestCommonAncestor(root.left, p, q);
		} else if (root.val < p.val && root.val < q.val) {
			root = lowestCommonAncestor(root.right, p, q);
		}
		return root;
	}
}
