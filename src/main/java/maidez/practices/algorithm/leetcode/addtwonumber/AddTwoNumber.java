package maidez.practices.algorithm.leetcode.addtwonumber;


public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        boolean exceed = false;
        ListNode head = null;
        ListNode cur = null;
        ListNode i1 = l1;
        ListNode i2 = l2;
        while (i1 != null || i2 != null || exceed) {
            int sum = (i1 == null ? 0 : i1.val) + (i2 == null ? 0 : i2.val) + (exceed ? 1 : 0);
            if (sum > 9) {
                sum %= 10;
                exceed = true;
            } else {
                exceed = false;
            }
            if (i1 != null) i1 = i1.next;
            if (i2 != null) i2 = i2.next;

            ListNode tmp = new ListNode(sum);
            if (head == null) {
                head = cur = tmp;
            } else {
                cur.next = tmp;
                cur = cur.next;
            }
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
