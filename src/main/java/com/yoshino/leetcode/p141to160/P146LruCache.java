package com.yoshino.leetcode.p141to160;

import java.util.*;

/**
 * LRU缓存机制
 * 最近最少使用淘汰算法
 */
public class P146LruCache {


}

class LRUCache {
    private int capacity;
    private int size;

    private Map<Integer, DLinkedNode> map = new HashMap<>();

    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            if (size == capacity) {
                DLinkedNode last = tail.prev;
                map.remove(last.key);
                removeNode(last);
                size--;
            }
            DLinkedNode node = new DLinkedNode(key, value);
            addToHead(node);
            map.put(key, node);
            size++;
        }
    }


    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DLinkedNode node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToTail(DLinkedNode node) {
        node.prev = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }

    class DLinkedNode {
        private int key;
        private int val;
        private DLinkedNode prev;
        private DLinkedNode next;

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public DLinkedNode() {}
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
