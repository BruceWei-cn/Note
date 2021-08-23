package com.ming.demo.leetcode.interview;

import java.util.Objects;
import org.junit.Test;

/**
 * @author Ming
 * @date 2021/8/23 13:59
 * @description
 */
public class Offer36 {

	/**
	 * 搜索与回溯：DFS
	 */
	@Test
	public void test() {

	}

	Node02 pre, head;

	/**
	 * 二叉搜索树转换为一个排序的双向链表
	 * <P>从排序可知采用 中序遍历（从小到大）</P>
	 */
	public Node02 treeToDoublyList(Node02 root) {
		if (Objects.isNull(root)) {
			return null;
		}
		dfs(root);
		// 首尾两个节点连接起来，形成循环链表
		head.left = pre;
		pre.right = head;
		return head;
	}

	/**
	 * 采用dfs，以中序遍历的方式
	 */
	private void dfs(Node02 curr) {
		// 先左，中，后右
		// curr 当前节点因为以中序向后遍历，若为null那么说明二叉树遍历完成，结束
		if (Objects.isNull(curr)) {
			return;
		}
		// 先递归左树
		dfs(curr.left);
		// pre为null,说明当前curr节点没有前置节点，同时也说明此时curr=head为头节点
		if (pre == null) {
			head = curr;
		} else {
			pre.right = curr;
		}
		// 当前节点的前置节点为pre
		curr.left = pre;
		// 节点向后移动
		pre = curr;
		dfs(curr.right);
	}
}
