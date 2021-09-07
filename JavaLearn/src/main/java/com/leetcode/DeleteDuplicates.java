package com.leetcode;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head){
        ListNode ans = new ListNode();

        ans.next =head;

        ListNode p = ans;

        while (p != null && p.next !=null && p.next.next != null){
            if(p.next.val == p.next.next.val){
                int x = p.next.val;
                while (p.next != null && p.next.val == x){
                    p.next = p.next.next;
                }
            }else {
                p = p.next;
            }
        }


        return ans.next;
    }
}
