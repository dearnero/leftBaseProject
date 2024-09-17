package com.hf.left.hot;

import com.hf.left.algorithms.definition.ListNode;

/**
 * @description: 23. 合并 K 个升序链表
 * 1. 要熟练的编写两个链表合并的代码
 * <a href="https://leetcode.cn/problems/merge-k-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/9/17 16:02
 * @version: 1.0
 */
public class HMergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {

//        ListNode dummy = new ListNode(-1);
//        for (int i = 0; i < lists.length; i++) {
//            ListNode l1 = lists[i], l2 = dummy.next, cur = dummy;
//            while (l1 != null && l2 != null){
//                if (l1.val > l2.val) {
//                    cur.next = l2;
//                    l2 = l2.next;
//                } else {
//                    cur.next = l1;
//                    l1 = l1.next;
//                }
//                cur = cur.next;
//            }
//            cur.next = l1 == null ? l2 : l1;l1
//        }
//        return dummy.next;

        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = merge2List(lists[i], ans);
        }
        return ans;
    }

    private ListNode merge2List(ListNode l1, ListNode l2){
        if (l1 == null && l2 == null) return null;
        ListNode ans = new ListNode(-1);
        ListNode cur = ans;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return ans.next;
    }

    public static void main(String[] args) {
       //  [[1,4,5],[1,3,4],[2,6]]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l4 = new ListNode(2);
        l4.next = new ListNode(6);

        new HMergeKLists().mergeKLists(new ListNode[]{l1, l2, l4});
    }
}
