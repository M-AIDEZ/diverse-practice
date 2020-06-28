package maidez.practices.algorithm.leetcode.sortlinkedlist;

public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = head;
        ListNode f = s.next;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        ListNode right = sortList(s.next);
        s.next = null;
        ListNode left = sortList(head);
        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode demon = new ListNode(0);
        ListNode cur = demon;
        ListNode index1 = l1;
        ListNode index2 = l2;
        while (index1 != null && index2 != null) {
            if (index1.val < index2.val) {
                cur.next = index1;
                index1 = index1.next;
            } else {
                cur.next = index2;
                index2 = index2.next;
            }
            cur = cur.next;
        }
        cur.next = index1 == null ? index2 : index1;
        return demon.next;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
