package com.xelllee.code.leetcode.stack;

import java.util.Stack;

public class MinStack {
/*
*
*
* Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.(peek())
getMin() -- Retrieve the minimum element in the stack.
*
*
* */

    public static void main(String[] args) {
    }

    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
    }

    public void pop() {
        if (stack.pop().intValue() == minStack.peek().intValue()) minStack.pop();
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {

        return minStack.peek();
    }


}
