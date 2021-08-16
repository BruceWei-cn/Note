package com.ming.demo.conding.algorithm.add;

/**
 * @author Ming
 * @date 2021/7/2 10:36
 * @description: 两个链表节点相加
 */
public class TwoListNodeAdd {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// 设置一个头节点，数据结构技巧，方便定位
		ListNode resultNode = new ListNode(-1);
		// 此处pre相当于指针
		ListNode pre = resultNode;
		System.out.println("pre = " + pre.hashCode());
		System.out.println("resultNode = " + resultNode.hashCode());
		int sum = 0;
		while (l1 != null || l2 != null || sum > 0) {
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			pre.next = new ListNode(sum % 10);
			// 指针向后移
			pre = pre.next;
			// 整除10，等于保留高位数字加到下一轮计算中
			sum /= 10;
		}
		return resultNode;
	}

	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		ListNode twoNumbers = addTwoNumbers(listNode1, listNode1);
		System.out.println("twoNumbers = " + twoNumbers);
	}
}
