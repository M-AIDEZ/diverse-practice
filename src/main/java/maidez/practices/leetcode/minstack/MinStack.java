package maidez.practices.leetcode.minstack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        Integer pop = stack.pop();
        if (minStack.peek().equals(pop)) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
//        ["MinStack","push","push","push","getMin","pop","getMin"]
//[[],[0],[1],[0],[],[],[]]
//        ["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
