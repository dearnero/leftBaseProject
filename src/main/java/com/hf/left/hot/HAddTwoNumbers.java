package com.hf.left.hot;

import com.hf.left.algorithms.definition.ListNode;

/**
 * @description: 2. 两数相加
 * @link <a href = "https://leetcode.cn/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/8/11 16:51
 * @version: 1.0
 */
public class HAddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null){
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        if (carry > 0){
            tail.next = new ListNode(1);
        }
        return head;
    }
}
