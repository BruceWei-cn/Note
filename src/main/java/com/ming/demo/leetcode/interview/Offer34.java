package com.ming.demo.leetcode.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;
import org.junit.Test;

/**
 * @author Ming
 * @date 2021/8/24 10:45
 * @description
 */
public class Offer34 {

	List<List<Integer>> res = new LinkedList<>();
	/**
	 * 用来存放路径
	 */
	List<Integer> path = new LinkedList<>();

	/**
	 * 二叉树和为某一值的路径
	 * <P>给定一棵二叉树，从根往下向叶节点形成的路径和为目标值</P>
	 */
	@Test
	public void test() {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);

	}

	public List<List<Integer>> pathSum(TreeNode root, int target) {
		dfs(root, target);
		return res;
	}

	/**
	 * 使用先序遍历，根-左-右
	 */
	private void dfs(TreeNode root, int target) {
		// 判断根
		if (Objects.isNull(root)) {
			return;
		}
		// 保存路径
		path.add(root.val);
		target = target - root.val;
		// 条件全部符合才行：1.target被减到0，2：一定要遍历到叶子节点
		if (target == 0 && Objects.isNull(root.left) && Objects.isNull(root.right)) {
			// 将符合条件的路径存入res
			res.add(new LinkedList<>(path));
		}
		// 左
		dfs(root.left, target);
		// 右
		dfs(root.right, target);
		// 树的递归：一侧走完，path内的元素全部删除
		path.remove(path.size() - 1);
	}
}
