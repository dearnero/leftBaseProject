package com.hf.left.hot;

import com.hf.left.algorithms.definition.ListNode;

/**
 * @description: 19. 删除链表的倒数第 N 个结点
 * 1. 需要技巧: 通过快慢双指针的方式，确定待删除节点的前继节点
 * 2. 注意: while循环终止条件是cur.next == null，不是cur==null
 * 3. 注意: 删除节点的代码:pre.next = pre.next.next;
 * X    1   2   3   X   ｜   2
 * pre      cur
 *      pre     cur
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/8/26 18:43
 * @version: 1.0
 */
public class HRemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = dummy;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        while (cur.next != null){
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head  = new ListNode(1);
        head.next = new ListNode(2);
        new HRemoveNthFromEnd().removeNthFromEnd(head, 1);
    }
}
