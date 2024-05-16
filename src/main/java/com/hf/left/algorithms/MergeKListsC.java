package com.hf.left.algorithms;

import com.hf.left.algorithms.definition.ListNode;

import java.util.List;

/**
 * 合并K个排序链表（Merge k Sorted Lists）
 * @description:
 * 给你一个链表数组，每个链表都已经按升序排列，请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 示例
 * 输入：lists = [[1->4->5],[1->3->4],[2->6]]
 * 输出：1->1->2->3->4->4->5->6
 * @author: huang fu
 * @date: 2024/5/16 22:46
 * @version: 1.0
 */
public class MergeKListsC {

    public ListNode mergeKLists(ListNode[] lists){
        if (lists == null || lists.length == 0){
            return null;
        }
        return merge(lists, 0, lists.length -1);
    }

    private ListNode merge(ListNode[] lists, int left, int right){
        if (left == right){
            return lists[left];
        }
        int mid = left + (right - left)/2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next  = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
