package maidez.practices.algorithm.leetcode.reverselist;

public class ReverseList {

    public ListNode reverseList_iterate(ListNode head) {
        ListNode prev = null;
        ListNode tmp = head;
        while (tmp != null) {
            ListNode next = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = next;
        }
        return prev;
    }

    public ListNode reverseList_recurse(ListNode head) {
        return reverseList_recurseHelper(null, head);
    }

    public ListNode reverseList_recurseHelper(ListNode prev, ListNode head) {
        if (head.next == null) {
            head.next = prev;
            return head;
        } else {
            ListNode reverseHead = reverseList_recurseHelper(head, head.next);
            head.next = prev;
            return reverseHead;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
