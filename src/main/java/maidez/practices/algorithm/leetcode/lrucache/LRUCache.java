package maidez.practices.algorithm.leetcode.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;

    private Map<Integer, Node> cache;

    private Node head;

    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
    }

    public static void main(String[] args) {
//        ["LRUCache","put","get","put","get","get"]
//[[1],[2,1],[2],[3,2],[2],[3]]
        LRUCache cache = new LRUCache(1 /* 缓存容量 */);
        cache.put(2, 1);
        System.out.println(cache.get(2));
        cache.put(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
        }
        return node.value;
    }

    private void moveToHead(Node node) {
        if (node.prev == null) return;
        node.prev.next = node.next;
        if (node.next == null) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }
        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            if (cache.size() >= capacity) {
                Node toRemove = this.cache.get(tail.key);
                tail = toRemove.prev;
                if (toRemove.prev == null) {
                    head = toRemove.next;
                } else {
                    toRemove.prev.next = null;
                }
                this.cache.remove(toRemove.key);
            }
            head = new Node(head, key, value);
            if (tail == null)
                tail = head;
            cache.put(key, head);
        }
    }

    private static class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(Node next, int key, int value) {
            this.next = next;
            this.key = key;
            this.value = value;
            if (next != null) next.prev = this;
        }
    }
}
