package com.leetcode;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        //set dump node
        ListNode ans = new ListNode();
        ans.next = head;

        ListNode cur = ans;

        while (cur.next != null && cur.next.next != null){

            //存储当前节点
            ListNode tempNext = cur.next;


            //把哑节点的下一节点指向要交换的后一个节点
            cur.next = tempNext.next;

            //交换节点
            tempNext.next = cur.next.next;

            cur.next.next = tempNext;


            cur = cur.next.next;
        }


        return ans.next;
    }
}
