package com.hf.left.hot;

import com.hf.left.algorithms.definition.ListNode;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/4 11:27
 * @version: 1.0
 */
public class HIsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        ListNode p1 = head, p2 = secondHalfStart;
        boolean isResult = true;
        while (isResult && p2 != null){
            if (p1.val != p2.val){
                isResult = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        firstHalfEnd.next = reverseList(secondHalfStart);
        return isResult;
    }

    private ListNode endOfFirstHalf(ListNode head){
        ListNode slow = head, fast = head;
        while (fast.next != null  && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head){
        ListNode prev = null, cur = head;
        while (cur != null){
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(2);
        ListNode r3 = new ListNode(2);
        ListNode r4 = new ListNode(1);
        r3.next = r4;
        r2.next = r3;
        r1.next = r2;
        new HIsPalindrome().isPalindrome(r1);
    }

}
