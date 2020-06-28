package maidez.practices.algorithm.leetcode.getintersectionnode;

public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode c5 = new ListNode(5);
        ListNode c4 = new ListNode(4);
        c4.next = c5;
        ListNode c8 = new ListNode(8);
        c8.next = c4;

        ListNode n1 = new ListNode(1);
        n1.next = c8;
        ListNode n4 = new ListNode(4);
        n4.next = n1;

        ListNode m1 = new ListNode(1);
        m1.next = c8;
        ListNode m0 = new ListNode(0);
        m0.next = m1;
        ListNode m5 = new ListNode(5);
        m5.next = m0;


        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();
        getIntersectionNode.getIntersectionNode(n4, m5);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = 1;
        ListNode tmpA = headA;
        while (tmpA.next != null) {
            lengthA++;
            tmpA = tmpA.next;
        }
        tmpA = headA;

        int lengthB = 1;
        ListNode tmpB = headB;
        while (tmpB.next != null) {
            lengthB++;
            tmpB = tmpB.next;
        }

        while (lengthA > 0 && lengthB > 0) {
            if (lengthA == lengthB) {
                if (tmpA == tmpB) {
                    return tmpA;
                }
                lengthA--;
                lengthB--;
                tmpA = tmpA.next;
                tmpB = tmpB.next;
            } else if (lengthA > lengthB) {
                lengthA--;
                tmpA = tmpA.next;
            } else {
                lengthB--;
                tmpB = tmpB.next;
            }
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
