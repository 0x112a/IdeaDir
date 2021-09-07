package com.leetcode;

public class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int x){
        val = x;
        next = null;
    }
    ListNode(int x, ListNode n){
        this.val = x;
        this.next = n;
    }
}
