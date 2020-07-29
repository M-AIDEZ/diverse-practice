package maidez.practices.algorithm.leetcode.no1521;

import java.util.Stack;

public class CQueue {
    private Stack<Integer> normal;
    private Stack<Integer> invert;

    public CQueue() {
        this.normal = new Stack<>();
        this.invert = new Stack<>();
    }

    public void appendTail(int value) {
        this.normal.push(value);
    }

    public int deleteHead() {
        int ans = -1;
        while (!normal.isEmpty()) {
            invert.push(normal.pop());
        }
        if (!invert.isEmpty()) {
            ans = invert.pop();
        }
        while (!invert.isEmpty()) {
            normal.push(invert.pop());
        }
        return ans;
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}
