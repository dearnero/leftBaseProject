package com.hf.left.interview;

import com.hf.left.algorithms.definition.ListNode;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/23 11:04
 * @version: 1.0
 */
public class IRotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head== null || head.next ==null){
            return head;
        }
        int length = 1;
        ListNode tail = head;
        while (tail.next != null){
            tail = tail.next;
            length++;
        }
        if (k % length == 0) return head;
        tail.next = head;
        int dif = length - k % length;
        ListNode rn = new ListNode(-1, head);
        for (int i = 0; i < dif; i++) {
            rn = rn.next;
        }
        ListNode ans = rn.next;
        rn.next = null;
        return ans;
    }
}
