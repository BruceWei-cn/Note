package com.ming.demo.leetcode.interview;

import java.util.HashMap;

/**
 * @author Ming
 * @date 2021/8/11 13:41
 * @description
 */
public class Offers35 {

	/**
	 * 复杂链表复制（携带random指针，指向任意）
	 */
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		node1.next = node2;
		node1.random = null;
		node2.random = null;
		node2.next = null;
		Node node = reverseNode(node1);
		System.out.println("node = " + node);
	}

	private static Node reverseNode(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		// 将一个链表，以及此链表后续引用全部赋予新链表；采用HashMap
		HashMap<Node, Node> nodeMap = new HashMap<>();
		Node curr = head;
		while (curr != null) {
			nodeMap.put(curr, new Node(curr.val));
			curr = curr.next;
		}
		curr = head;
		while (curr != null) {
			// 根据key获取到值 = 获取key对应的后续引用
			nodeMap.get(curr).next = nodeMap.get(curr.next);
			nodeMap.get(curr).random = nodeMap.get(curr.random);
			curr = curr.next;
		}
		return nodeMap.get(head);
	}
}
