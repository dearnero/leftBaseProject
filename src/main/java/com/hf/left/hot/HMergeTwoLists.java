package com.hf.left.hot;

import com.hf.left.algorithms.definition.ListNode;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/22 18:18
 * @version: 1.0
 */
public class HMergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (list1 != null && list2 != null){
            if (list1.val > list2.val){
                tail.next = new ListNode(list2.val);
                list2 = list2.next;
            }else {
                tail.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            tail = tail.next;
        }
        tail.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}
