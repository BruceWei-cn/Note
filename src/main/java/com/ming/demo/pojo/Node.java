package com.ming.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: Ming
 * @Date: 2021/1/19 19:44
 * @Description: 链表节点常量类
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
public class Node {

	private int data;

	private Node next;

	public Node(int data) {
		this.data = data;
	}

	public Node(Node next) {
		this.next = next;
	}
}
