package com.hf.left.algorithms.linkedlist;

/**
 * @description: LinkedList
 * @author: huang fu
 * @date: 2024/6/17 09:37
 * @version: 1.0
 */
public class LinkedList {

    Node head;

    static class Node{

        int data;

        Node next;

        Node(int d){
            this.data = d;
            next = null;
        }
    }

    public LinkedList insert(LinkedList list, int val){
        Node new_node = new Node(val);
        if (list.head == null){
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null){
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }
}
