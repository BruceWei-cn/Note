package com.ming.demo.leetcode.interview;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.TreeMap;
import org.junit.Test;

/**
 * @author Ming
 * @date 2021/8/23 10:19
 * @description
 */
public class Offer54 {

	@Test
	public void test() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		System.out.println(kthLargest(root, 1));
		System.out.println(kthLargest02(root, 1));
	}

	/**
	 * 搜索第K大的节点
	 * <P>思考：使用BFS遍历，排序，取值</P>
	 */
	public int kthLargest(TreeNode root, int k) {
		Queue<TreeNode> queue = new LinkedList<>();
		if (Objects.nonNull(root)) {
			queue.add(root);
		}
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			treeMap.put(node.val, node.val);
			if (Objects.nonNull(node.right)) {
				queue.add(node.right);
			}
			if (Objects.nonNull(node.left)) {
				queue.add(node.left);
			}
		}
		// 借助TreeMap有序的特性
		Integer result = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++) {
			if (i != k - 1) {
				treeMap.remove(treeMap.lastKey());
			} else {
				result = treeMap.lastKey();
				break;
			}
		}
		return result;
	}


	int res;
	int k;

	/**
	 * 使用DFS
	 */
	public int kthLargest02(TreeNode root, int k) {
		// k要作为全局变量,相当于需要记录递归的进程
		this.k = k;
		dfs(root);
		return res;
	}

	/**
	 * DFS的具体实现方式
	 * <P>中序遍历的倒序</P>
	 * <P> 解释：中序：左中右（值的顺序是由小到大），倒序即为：右中左（值的顺序即为由大到小更符合题意）</P>
	 */
	private void dfs(TreeNode root) {
		if (Objects.isNull(root)) {
			return;
		}
		// 先右
		dfs(root.right);
		// 中间判断
		if (--k == 0) {
			// 倒序（从大到小）第k个值即为我们要找的
			res = root.val;
			return;
		}
		// 最后左
		dfs(root.left);
	}
}
