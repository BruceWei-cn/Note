package com.ming.demo.leetcode.interview;

import java.util.Objects;

/**
 * @author Ming
 * @date 2021/8/20 18:55
 * @description
 */
public class Offer52 {

	public static void main(String[] args) {
		ListNode headA = new ListNode(1);
		headA.next = new ListNode(2);
		headA.next.next = new ListNode(3);
		ListNode headB = new ListNode(0);
		headB.next = new ListNode(2);
		headB.next.next = new ListNode(3);
		System.out.println(getIntersectionNode(headA, headB));
	}

	/**
	 * 找出两个链表相交点的节点，分为两种情况
	 * <P>1. 两个链表长度相等</P>
	 * <P>2. 两个链表长度不等</P>
	 */
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (Objects.isNull(headA) || Objects.isNull(headB)) {
			return null;
		}
		ListNode pA = headA;
		ListNode pB = headB;
		while (pA != pB) {
			pA = pA == null ? headB : pA.next;
			pB = pB == null ? headA : pB.next;
		}
		return pA;
	}
}
