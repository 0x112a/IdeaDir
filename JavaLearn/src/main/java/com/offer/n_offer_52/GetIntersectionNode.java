package com.offer.n_offer_52;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while (p != q){

            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null;}
}