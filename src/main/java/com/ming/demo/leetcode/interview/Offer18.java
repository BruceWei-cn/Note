package com.ming.demo.leetcode.interview;

/**
 * @author Ming
 * @date 2021/8/19 14:50
 * @description
 */
public class Offer18 {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println(deleteNode(head, 0));
	}

	/**
	 * 在链表中找到目标值，并删除它
	 */
	public static ListNode deleteNode(ListNode head, int val) {
		if (head.val == val) {
			return head.next;
		}
		// 两个指针，分别指向链表的第一第二位置
		// 两个对象，分别引用head链表的实例数据
		ListNode pre = head;
		ListNode curr = head.next;
		while (curr != null) {
			if (curr.val == val) {
				pre.next = curr.next;
			}
			curr = curr.next;
			pre = pre.next;
		}
		return head;
	}
}
