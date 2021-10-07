package com.offer.n_offer_6;

public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        ListNode p = head;
        int len = 0;
        while (p != null ){
            len++;
            p = p.next;
        }

        p = head;
        int[] ans = new int[len];
        for (int i = len -1; i >= 0; i--){
            ans[i] = p.val;
            p=p.next;
        }
        return ans;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }