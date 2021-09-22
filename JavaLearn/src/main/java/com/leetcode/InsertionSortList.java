package com.leetcode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head){

        ListNode dump = new ListNode(-1,head);

        ListNode p = head.next;
        head.next = null;

        //依次从原列表中取元素
        while (p != null){

            ListNode q = p.next;
            p.next=null;

            //pre,post
            ListNode pre = dump,post = dump.next;

            while (post != null){
                if (p.val > post.val){
                    post=post.next;
                    pre = pre.next;
                }else {
                    break;
                }
            }
            //插入点在pre和post之间
            p.next=post;
            pre.next=p;

            //移动p指针
            p = q;

        }


        return null;
    }
}
