package com.ming.demo.leetcode.interview;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 模拟一个栈，找出其中元素
 *
 * @author Ming
 * @date 2021/9/27 17:29
 */
public class Number155 {

	/**
	 * 利用Deque模拟栈,时间复杂度O(1),空间复杂度O(n)
	 */
	LinkedList<Integer> stack;
	Deque<Integer> minStack;

	public Number155() {
		stack = new LinkedList<>();
		minStack = new LinkedList<>();
		minStack.push(Integer.MAX_VALUE);
	}

	public void push(Integer x) {
		stack.push(x);
		minStack.push(Math.min(minStack.peek(), x));
	}

	public void pop() {
		stack.pop();
		minStack.pop();
	}

	public Integer top() {
		return stack.peek();
	}

	public Integer getMin() {
		return minStack.peek();
	}
}
