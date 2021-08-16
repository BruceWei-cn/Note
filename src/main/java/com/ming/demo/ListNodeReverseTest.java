package com.ming.demo;

import com.ming.demo.pojo.Node;
import org.junit.Test;

/**
 * @author: Ming
 * @Date: 2021/1/19 17:18
 * @Description: 链表反转的算法测试
 */
public class ListNodeReverseTest {

	@Test
	public void test01() {
		Node head = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		head.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		System.out.println(reverseList01(head));
	}

	/**
	 * 反转链表
	 */
	public Node reverseList01(Node head) {
		if (head == null) {
			return null;
		} else if (head.getNext() == null) {
			return head;
		}

		// 指向前一个
		Node pre = null;
		// 指向当前
		Node current = head;
		// 指向下一个
		Node temp;

		while (current != null) {
			temp = current.getNext();
			current.setNext(pre);
			pre = current;
			current = temp;
		}
		return pre;
	}
}
