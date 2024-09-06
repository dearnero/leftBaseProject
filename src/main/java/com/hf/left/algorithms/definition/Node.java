package com.hf.left.algorithms.definition;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/6 15:05
 * @version: 1.0
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
