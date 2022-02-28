package com.ming.demo.leetcode.algorithm.recursion;

import lombok.Data;

@Data
public class Node {

	int val;
	Node next;

	Node(){}

	Node(int val) {
		this.val = val;
	}

	Node(int val, Node next) {
		this.val = val;
		this.next = next;
	}
}