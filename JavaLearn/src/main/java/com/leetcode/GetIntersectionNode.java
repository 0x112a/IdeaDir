package com.leetcode;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        if (a == null || b == null){
            return null;
        }

        while (a!=b){

//            if (a == null && b != null){
//                a = headB;
//            }
//            if (a!=null && b == null){
//                b = headA;
//            }
//
//            a=a.next;
//            b=b.next;

            a = a == null ? a = headB : a.next;
            b = b == null ? b = headA : b.next;
        }

        return a;

    }
}
