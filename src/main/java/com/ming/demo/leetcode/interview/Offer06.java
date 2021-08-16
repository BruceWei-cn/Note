package com.ming.demo.leetcode.interview;

import java.util.Arrays;

/**
 * @author Ming
 * @date 2021/8/10 16:35
 * @description 剑指offer-06
 */
public class Offer06 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		System.out.println(Arrays.toString(reversePrint(l1)));
	}

	/**
	 * 链表以数组的方式返回
	 */
	public static int[] reversePrint(ListNode head) {
		int count = 0;
		ListNode node = head;
		while (node != null) {
			++count;
			node = node.next;
		}
		// 先确定数组的长度
		int[] ints = new int[count];
		node = head;
		for (int i = count - 1; i >= 0; i--) {
			ints[i] = node.val;
			node = node.next;
		}
		return ints;
	}
}
