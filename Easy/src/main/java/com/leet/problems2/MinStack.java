package com.leet.problems2;

import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(0);
        stack.push(1);
        stack.push(0);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }


    Stack<Integer> theOne;
    Stack<Integer> theMin;

    public MinStack() {
        theOne = new Stack<>();
        theMin = new Stack<>();
    }

    public void push(int val) {
        theOne.push(val);
        if (theMin.isEmpty() || theMin.peek() >= val) {
            theMin.push(val);
        }
    }

    public void pop() {
        int popped = theOne.pop();
        if (theMin.peek() == popped) {
            theMin.pop();
        }
    }

    public int top() {
        return theOne.peek();
    }

    public int getMin() {
        return theMin.peek();
    }
}
