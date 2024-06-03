package com.hf.left.algorithms;

import com.hf.left.algorithms.definition.ListNode;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {

    public ListNode addTwoNumbers(ListNode head1, ListNode head2){
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        ListNode addList = addReversed(head1, head2);
        return reverseList(addList);
    }

    public ListNode addReversed(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode sumNode = dummy;
        int carry = 0;
        while (head1 != null || head2 != null){
            int sum = (head1 == null ? 0 : head1.val) + (head2 == null ? 0 : head2.val);
            carry = sum > 10 ? 1 : 0;
            int newSumVal = sum > 10 ? sum - 10 : sum;
            sumNode.next = new ListNode(newSumVal);
            sumNode = sumNode.next;
            head1 = head1 != null ? head1.next : null;
            head2 = head2 != null ? head2.next : null;
        }
        if (carry > 0){
            sumNode.next = new ListNode(1);
        }
        return dummy;
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur.next != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode tem1 = new ListNode(1);
    }
}
