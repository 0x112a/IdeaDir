package com.offer.n_offer_25;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);

        ListNode cur = dummy;

        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                cur.next = l2;
                cur =cur.next;
                l2 = l2.next;
            }else {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }
        }

        cur.next = l1 == null ? l2 : l1;

        return dummy.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
