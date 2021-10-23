package com.offer.n_offer_41;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    /** initialize your data structure here. */
    Queue<Integer> A,B;

    public MedianFinder() {
        A = new PriorityQueue<>();
        B = new PriorityQueue<>((x,y) -> (y-x));
    }

    public void addNum(int num) {
        if (A.size() != B.size()){
            A.add(num);
            B.add(A.poll());
        }else {
            B.add(num);
            A.add(B.poll());
        }

    }

    public double findMedian() {
        if (A.size() == B.size()){
            return (A.peek()+B.peek())/2.0;
        }
        return (double) A.peek();
    }
}
