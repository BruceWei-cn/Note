package com.ming.demo.leetcode.interview;

class Node02 {
    public int val;
    public Node02 left;
    public Node02 right;

    public Node02() {}

    public Node02(int _val) {
        val = _val;
    }

    public Node02(int _val,Node02 _left,Node02 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};