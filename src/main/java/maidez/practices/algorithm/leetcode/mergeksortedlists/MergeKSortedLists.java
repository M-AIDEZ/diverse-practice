package maidez.practices.algorithm.leetcode.mergeksortedlists;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode cur = null;
        int minIndex = findMinIndex(lists);
        while (minIndex != -1) {
            if (head == null) {
                cur = lists[minIndex];
                head = cur;
            } else {
                cur.next = lists[minIndex];
                cur = cur.next;
            }
            lists[minIndex] = lists[minIndex].next;
            minIndex = findMinIndex(lists);
        }
        return head;
    }

    private static int findMinIndex(ListNode[] lists) {
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            if (lists[i].val < minValue) {
                minIndex = i;
                minValue = lists[i].val;
            }
        }
        return minIndex;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
