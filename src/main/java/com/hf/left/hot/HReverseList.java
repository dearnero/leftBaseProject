package com.hf.left.hot;

import com.hf.left.algorithms.definition.ListNode;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/1 12:28
 * @version: 1.0
 */
public class HReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, prev = null;
        while (cur != null){
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }
}
