package com.hf.left.hot;

import com.hf.left.algorithms.definition.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/29 22:19
 * @version: 1.0
 */
public class HGetIntersectionNode {


    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa = headA, pb = headB;
        while (pa != pb){
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;

        }
        return pa;

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> temp = new HashSet<>();
        while (headA != null){
            temp.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if (temp.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
