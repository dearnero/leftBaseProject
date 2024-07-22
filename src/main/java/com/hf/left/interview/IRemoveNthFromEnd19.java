package com.hf.left.interview;

import com.hf.left.algorithms.definition.ListNode;

/**
 * @description:
 * @link <a href = "https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-interview-150">19. 删除链表的倒数第 N 个结点</a>
 * @author: huang fu
 * @date: 2024/7/22 20:49
 * @version: 1.0
 */
public class IRemoveNthFromEnd19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode left = dummy;
        ListNode right = head;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        while (right != null){
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
