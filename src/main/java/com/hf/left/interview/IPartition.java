package com.hf.left.interview;

import com.hf.left.algorithms.definition.ListNode;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/25 11:21
 * @version: 1.0
 */
public class IPartition {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head !=null){
            if (head.val < x){
                small.next = new ListNode(head.val);
                small = small.next;
            }else {
                large.next = new ListNode(head.val);
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
