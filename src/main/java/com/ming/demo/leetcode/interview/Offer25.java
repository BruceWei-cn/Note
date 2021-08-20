package com.ming.demo.leetcode.interview;

import java.util.Objects;

/**
 * @author Ming
 * @date 2021/8/20 17:06
 * @description
 */
public class Offer25 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(2);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(4);
		System.out.println(mergeTwoLists(l1, l2));
		System.out.println(mergeTwoLists02(l1, l2));
	}

	/**
	 * 合并两个排序链表，合并之后也为有序
	 * <p>使用递归来做，时间复杂度O(n),空间复杂度O(1)</p>
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (Objects.isNull(l1)) {
			return l2;
		}
		if (Objects.isNull(l2)) {
			return l1;
		}
		// 头节点，方便定位
		ListNode result = new ListNode(0);
		ListNode curr = result;
		while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
			if (l1.val <= l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		curr.next = Objects.nonNull(l1) ? l1 : l2;
		return result.next;
	}

	/**
	 * 递归的方式
	 * <P>思考递归，一定不能套进去，想好递归公式，结束条件，逻辑关系 三要素就好</P>
	 */
	public static ListNode mergeTwoLists02(ListNode l1, ListNode l2) {
		// 结束条件
		if (Objects.isNull(l1) || Objects.isNull(l2)) {
			return Objects.isNull(l1) ? l2 : l1;
		}
		// 逻辑关系
		if (l1.val <= l2.val) {
			// 递归公式
			l1.next = mergeTwoLists02(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists02(l1, l2.next);
			return l2;
		}
	}
}
