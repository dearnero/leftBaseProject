package com.hf.left.hot;

import com.hf.left.algorithms.definition.ListNode;

/**
 * @description: 148. 排序链表(归并排序)
 * 算法： 归并排序+双指针
 * 1. 使用快慢双指针找到中间位置，作为分割节点
 * 2. 左右两边分别进行再次递归
 *  2.1 递归终止条件：head == null || head.next == null
 * 3. 对排好序的左右两边进行合并操作
 *  3.1 合并的算法还是使用双指针的方式
 * @link <a href ="https://leetcode.cn/problems/sort-list/description/?envType=study-plan-v2&envId=top-100-liked">148. 排序链表</a>
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
