package com.offer.n_offer_9;


import java.util.Deque;
import java.util.LinkedList;

public class CQueue {

    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public CQueue() {
        this.inStack = new LinkedList<>();
        this.outStack = new LinkedList<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        if (outStack.isEmpty()){
            return -1;
        }else {

            return outStack.pop();
        }
    }
}
