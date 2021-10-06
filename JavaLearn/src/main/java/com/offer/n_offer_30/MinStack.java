package com.offer.n_offer_30;


import java.util.*;

public class MinStack {

    Deque<Integer> minStack;
    Deque<Integer> stack;


    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();

    }

    public void push(int x) {
        stack.push(x);
        Integer peek = minStack.peek();
        if(peek == null){
            peek = Integer.MAX_VALUE;
        }
        minStack.push(Math.min(peek,x));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
