package com.offer.n_offer_18;

public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre,cur;
        ListNode ans = new ListNode(-1);
        ans.next = head;
        pre = ans;
        cur = head;

        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }

        return ans.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}