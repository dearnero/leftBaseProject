package com.hf.left.hot;

import com.hf.left.algorithms.definition.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 138. 随机链表的复制
 * 本题有两种方案：1. 两次循环；2. 递归
 * 此处建议使用递归，代码简而美
 * <a href="https://leetcode.cn/problems/copy-list-with-random-pointer/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/9/6 15:05
 * @version: 1.0
 */
public class HCopyRandomList {

    public Node copyRandomList(Node head) {
        Map<Node, Node> temp = new HashMap<>();
        Node cur1 = head;
        while (cur1 != null){
            temp.put(cur1, new Node(cur1.val));
            cur1 = cur1.next;
        }
        Node dummy = new Node(0);
        Node cur = dummy;
        while (head != null){
            Node node = temp.get(head);
            node.random = head.random == null ? null : temp.get(head.random);
            cur.next = node;
            cur = cur.next;
            head = head.next;
        }
        return dummy.next;
    }

    Map<Node, Node> cachedNode = new HashMap<>();

    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        if (!cachedNode.containsKey(head)){
            Node newNode = new Node(head.val);
            cachedNode.put(head, newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}
