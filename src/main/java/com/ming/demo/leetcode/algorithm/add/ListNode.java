package com.ming.demo.leetcode.algorithm.add;

import lombok.Data;

/**
 * @author: Ming
 * @Date: 2021/6/1 10:40
 * @Description:
 */
@Data
public class ListNode {

	int val;
	ListNode next;

	ListNode(){}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
