package com.hf.left.hot;

import com.hf.left.algorithms.definition.ListNode;

/**
 * @description: 142. 环形链表 II
 * 算法：双指针
 * 1. 使用快慢双指针的方式，每次执行，快指针比慢指针快一倍
 * 2. 当快指针再次追上慢指针时, 定义新指针pre == head
 * 3. 开始寻找换环点，开始执行pre、slow， 当两者相等时，即为环点
 * 注意点: 终止条件为fast!=null && fast.next!=null
 * @link <a href = "https://leetcode.cn/problems/linked-list-cycle-ii/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/7/29 15:13
 * @version: 1.0
 */
public class HDetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                ListNode pre = head;
                while (pre != slow){
                    pre = pre.next;
                    slow = slow.next;
                }
                return pre;
            }
        }
        return null;
    }
}
