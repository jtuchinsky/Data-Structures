package com.intertuma.algorithms.leetcode.week2;

import org.junit.Test;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        mainStack.push(x);
        if(minStack.empty() || x <= minStack.peek())
            minStack.push(x);
    }

    public void pop() {
        if (!mainStack.empty()) {
            int top = mainStack.pop();
            if(top == minStack.peek())
                minStack.pop();
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    @Test
    public void test(){
        MinStack s = new MinStack();
        s.push(0);
        s.push(1);
        s.push(0);
        s.pop();
        s.pop();
        System.out.println(s.getMin());
    }
}
