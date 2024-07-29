package com.hf.left.hot;

import com.hf.left.algorithms.definition.ListNode;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/29 14:38
 * @version: 1.0
 */
public class HSortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode rigth = sortList(fast);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null && rigth != null){
            if (left.val > rigth.val){
                cur.next = new ListNode(rigth.val);
                rigth = rigth.next;
            } else {
                cur.next = new ListNode(left.val);
                left = left.next;
            }
            cur = cur.next;
        }
        if (left != null) {cur.next = left;}
        if (rigth != null) {cur.next = rigth;}
        return dummy.next;
    }
}
