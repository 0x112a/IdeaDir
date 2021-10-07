package com.offer.n_offer_24;

public class reverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;

        ListNode dummp = new ListNode(-1);
        ListNode p = head;

        while (p != null){
            //头插法
            ListNode q = p.Next;

            p.Next = dummp.Next;
            dummp.Next = p;

            p = q;
        }

        return dummp.Next;
    }
}

class ListNode{
    int Val;
    ListNode Next;
    public ListNode(int x){this.Val = x;}
}
