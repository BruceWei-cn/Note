package com.ming.demo.leetcode.algorithm.recursion;

import org.junit.Test;

/**
 * @author Ming
 * @date 25/2/2022-下午 12:20
 */
public class RecursionDemo {

    /**
     * 输入 1->2->3->4, 在不借助其他数据结构并不改变输入的情况下反向打印出4321,注意不能修改输入或复制输入
     */
    public static void print(Node node) {
        if (node == null || node.next == null){
            System.out.println("node = " + node.val);
            return;
        }
        print(node.next);
        System.out.println("node = " + node.val);
    }

    @Test
    public void test(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        print(node1);
        System.out.println("node1 = " + node1);
    }
}
