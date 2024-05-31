package com.hf.left.algorithms;

import com.hf.left.algorithms.definition.ListNode;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/5/31 16:44
 * @version: 1.0
 */
public class LinkedTest {

    public ListNode append(ListNode head, int value){

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode target = new ListNode(value);
        ListNode node = dummy;
        while (node.next != null){
            node = node.next;
        }
        node.next = target;
        return dummy;
    }

    public ListNode delete(ListNode head, int value){

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = dummy;
        while (node.next != null){
            if (node.next.val == value){
                node.next = node.next.next;
            }
            node = node.next;
        }
        return dummy;
    }

    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode front = head, back = dummy;
        for (int i = 0; i < n; i++) {
            front = front.next;
        }
        while (front !=null){
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return dummy.next;
    }
}
