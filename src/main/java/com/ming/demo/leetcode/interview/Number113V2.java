package com.ming.demo.leetcode.interview;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.junit.Test;

/**
 * @author Ming
 * @date 2021/8/24 14:11
 * @description 类似题目Offer34
 */
public class Number113V2 {

	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(pathSum(root, 3));
	}

	/**
	 * 全局变量
	 */
	List<List<Integer>> res = new LinkedList<>();
	List<Integer> path = new LinkedList<>();

	/**
	 * 路径总和
	 * <P>根据给点的目标值，找出二叉树中从根节点到叶子节点的路径总和 = 目标值的路径</P>
	 */
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		dfs(root, targetSum);
		return res;
	}

	/**
	 * 搜索与回溯： 根据题意此题利用前序遍历+dfs
	 */
	private void dfs(TreeNode root, int targetSum) {
		// 判断根若为null直接返回
		if (Objects.isNull(root)) {
			return;
		}
		// 根
		path.add(root.val);
		targetSum -= root.val;
		if (Objects.isNull(root.left) && Objects.isNull(root.right) && targetSum == 0) {
			// 将值赋值给res而不是将引用赋值
			res.add(new LinkedList<>(path));
		}
		// 左
		dfs(root.left, targetSum);
		// 右
		dfs(root.right, targetSum);
		// 退回上一个父树节点(随着回溯一个一个移除队列)
		path.remove(path.size() - 1);
	}
}
