package com.leetcode;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode ans = new ListNode(0,head);

        ListNode cur = ans;

        while (cur !=null){
            ListNode tail = cur;

            //检查链表是否够长
            for (int i = 0; i < k; i++) {
                tail=tail.next;
                if (tail == null){
                    return ans.next;
                }
            }

            ListNode headT = new ListNode(0,null);

            ListNode t = cur.next;

            ListNode p = cur.next;

            ListNode p2 = p.next;

            for (int i = 0; i < k; i++) {

                p.next = headT.next;

                headT.next = p;

                p = p2;

                p2 =p2.next;

            }

            t.next = p2;

            cur.next = headT.next;

            cur = t;
        }

        return ans.next;
    }
}
