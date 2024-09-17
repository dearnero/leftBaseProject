package com.hf.left.hot;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/17 18:34
 * @version: 1.0
 */
public class HLRUCache {

    class DLinkedNode{
        int key;
        int val;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key, int val) {this.key = key; this.val = val;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();

    private int size;

    private int capacity;

    private DLinkedNode head, tail;

    public HLRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode dLinkedNode = cache.get(key);
        if (dLinkedNode == null) {
            return -1;
        }
        moveToHead(dLinkedNode);
        return dLinkedNode.val;
    }

    public void put(int key, int value) {
        DLinkedNode dLinkedNode = cache.get(key);
        if (dLinkedNode == null) {
            DLinkedNode node = new DLinkedNode(key, value);
            cache.put(key, node);
            addToHead(node);
            ++size;
            if (size > capacity){
                DLinkedNode dLinkedNode1 = removeTail();
                cache.remove(dLinkedNode1.key);
                --size;
            }
        }else {
            dLinkedNode.val = value;
            moveToHead(dLinkedNode);
        }
    }

    private void addToHead(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(DLinkedNode dLinkedNode) {
        removeNode(dLinkedNode);
        addToHead(dLinkedNode);
    }

    private DLinkedNode removeTail(){
        DLinkedNode prev = tail.prev;
        removeNode(prev);
        return prev;
    }

    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


}
