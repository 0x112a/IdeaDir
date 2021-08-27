package com.leetcode;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {

        if (head == null){
            return head;
        }

        ListNode ans = null;

        ListNode slow = head, fast = head;

        while (fast != null){
            slow = slow.next;
            if (fast.next != null){
                fast = fast.next.next;
            }else {
                return null;
            }

            if (slow == fast){
                ans = head;

                while (ans != slow){
                    ans=ans.next;
                    slow = slow.next;
                }
                return ans;
            }
        }


        return ans;
    }
}
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}