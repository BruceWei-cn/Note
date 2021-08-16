package com.ming.demo.leetcode.algorithm.listnode;

import org.junit.Test;

/**
 * @author: Ming
 * @Date: 2021/6/1 13:33
 * @Description: 单链表反转
 */
public class ReverseList {

	/**
	 * 迭代：时间复杂度 O(n),空间复杂度 O(1)
	 */
	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode next;
		if (head == null || head.next == null) {
			return head;
		}
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

	/**
	 * 同上
	 */
	public ListNode reverseList2(ListNode head) {
		ListNode pre = null;
		ListNode curr = head;
		if (head == null || head.next == null) {
			return head;
		}
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		return pre;
	}

	@Test
	public void reverseListTest() {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		listNode5.next = null;
		System.out.println("listNode = " + listNode1);
		/*ListNode reverseList = reverseList(listNode1);
		System.out.println("reverseList = " + reverseList);*/
		/*ListNode reverseList2 = reverseList2(listNode1);
		System.out.println("reverseList2 = " + reverseList2);*/

		ListNode test03 = test03(listNode1);
		System.out.println("test03 = " + test03);
	}

	private ListNode test03(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		return pre;
	}
}
