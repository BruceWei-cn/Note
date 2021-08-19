package com.ming.demo.leetcode.interview;

import java.util.Objects;

/**
 * @author Ming
 * @date 2021/8/19 11:16
 * @description
 */
public class Offer22 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println(getKthFromEnd(head, 2));
	}


	/**
	 * 使用双指针,一前一后，后指针到末尾前指针即为输出ListNode
	 */
	public static ListNode getKthFromEnd(ListNode head, int k) {
		if (Objects.isNull(head)) {
			return null;
		}
		// 前指针
		ListNode pre = head;
		// 后指针
		ListNode after = head;
		for (int i = 0; i < k; i++) {
			// 后指针：向后移动k位
			after = after.next;
		}
		while (after != null) {
			pre = pre.next;
			after = after.next;
		}
		return pre;
	}
}
