package maidez.practices.algorithm.leetcode.allone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllOne {

    private Map<String, Node> cache;

    private Node min;

    private Node max;

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        this.cache = new HashMap<>();
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("a");
        allOne.inc("b");
        allOne.dec("b");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        Node node = cache.get(key);
        if (node == null) {
            if (min == null) {
                node = new Node(null, null, 1, key);
                cache.put(key, node);
                min = node;
                max = node;
            } else if (min.count == 1) {
                min.strings.add(key);
                cache.put(key, min);
            } else {
                node = new Node(null, min, 1, key);
                min = node;
                cache.put(key, node);
            }
        } else {
            if (node.next == null) {
                max = new Node(node, null, node.count + 1, key);
                cache.put(key, max);
            } else {
                if (node.next.count == node.count + 1) {
                    node.next.strings.add(key);
                    cache.put(key, node.next);
                } else {
                    if (node.strings.size() == 1) {
                        node.count++;
                        return;
                    } else {
                        new Node(node, node.next, node.count + 1, key);
                        cache.put(key, node.next);
                    }
                }
            }

            node.strings.remove(key);
            if (node.strings.size() == 0) {
                if (node.prev == null) {
                    min = node.next;
                } else {
                    node.prev.next = node.next;
                }
                node.next.prev = node.prev;
                node.next = null;
                node.prev = null;
            }
        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        Node node = cache.get(key);
        if (node == null) {
            return;
        }
        if (node.prev == null) {
            if (node.count > 1) {
                min = new Node(null, node, node.count - 1, key);
                cache.put(key, min);
            }
        } else {
            if (node.prev.count == node.count - 1) {
                node.prev.strings.add(key);
                cache.put(key, node.prev);
            } else {
                if (node.strings.size() == 1) {
                    node.count--;
                    return;
                } else {
                    new Node(node.prev, node, node.count - 1, key);
                    cache.put(key, node.prev);
                }
            }
        }

        node.strings.remove(key);
        if (node.strings.size() == 0) {
            if (node.next == null) {
                max = node.prev;
            } else {
                node.next.prev = node.prev;
            }
            if (node.prev != null) {
                node.prev.next = node.next;
                node.prev = null;
            } else {
                min = min.next;
            }
            node.next = null;
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return max == null ? "" : max.strings.get(0);
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        return min == null ? "" : min.strings.get(0);
    }

    private static class Node {
        Node prev;
        Node next;
        int count;
        List<String> strings;

        public Node(Node prev, Node next, int count, String string) {
            this.prev = prev;
            if (prev != null) prev.next = this;
            this.next = next;
            if (next != null) next.prev = this;
            this.count = count;
            this.strings = new ArrayList<>();
            this.strings.add(string);
        }
    }
}
