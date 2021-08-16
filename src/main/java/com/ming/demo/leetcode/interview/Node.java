package com.ming.demo.leetcode.interview;

import lombok.Data;

/**
 * 特殊链表，带random
 */
@Data
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}