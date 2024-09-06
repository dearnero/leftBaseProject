package com.hf.left.hot;

import com.hf.left.algorithms.definition.ListNode;

/**
 * @description: 24. 两两交换链表中的节点
 * 没有什么特殊的技巧，完全考验对于链表的代码功底
 * <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/9/5 22:28
 * @version: 1.0
 */
public class HSwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, cur = head;
        while (cur != null && cur.next!= null){
            ListNode temp = cur.next.next;
            prev.next = cur.next;
            cur.next = temp;
            prev.next.next = cur;
            cur = cur.next;
            prev = prev.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        new HSwapPairs().swapPairs(head);
    }
}
