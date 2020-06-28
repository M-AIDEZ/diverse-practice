package maidez.practices.algorithm.leetcode.no1591;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNodeLcci {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> occurred = new HashSet<>();
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            if (occurred.contains(cur.val)) {
                prev.next = cur.next;
            } else {
                occurred.add(cur.val);
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
