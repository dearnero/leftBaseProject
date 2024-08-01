package com.hf.left.hot;

import com.hf.left.algorithms.definition.ListNode;

/**
 * @description: 25. K 个一组翻转链表
 * 算法：双指针、链表互换操作
 * 1. 记得把互换逻辑单独抽离，并且要写的非常的熟练
 * @link <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/8/1 12:12
 * @version: 1.0
 */
public class HReverseKGroup {

    // [1,2,3,4,5] k = 2
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode lf = dummy, rt = dummy;
        int kCount = 0;
        while (rt != null){
            if (kCount == k){
                ListNode h = lf.next, t = rt.next;
                rt.next = null;
                lf.next = reverse(h);
                h.next = t;
                lf = h;
                rt = h;
                kCount = 0;
            }
            rt = rt.next;
            kCount++;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head){
        ListNode cur = head, prev = null;
        while (cur != null){
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode root5 = new ListNode(5);
        ListNode root4 = new ListNode(4, root5);
        ListNode root3 = new ListNode(3, root4);
        ListNode root2 = new ListNode(2, root3);
        ListNode root1 = new ListNode(1, root2);
        new HReverseKGroup().reverseKGroup(root1, 2);
    }
}
