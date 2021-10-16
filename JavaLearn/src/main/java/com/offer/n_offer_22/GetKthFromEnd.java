package com.offer.n_offer_22;

public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow,fast;
        if (head == null) return null;

        fast = head;
        slow = head;
        //note 注意边界
        int distance = 0;
        while (fast != null){
            if (distance == k){
                slow = slow.next;
                distance--;
            }

            fast = fast.next;
            distance++;
        }

        if (distance < k){
            return null;
        }
        return slow;

    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
