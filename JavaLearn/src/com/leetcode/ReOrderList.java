package com.leetcode;

public class ReOrderList {
    /**
     *方法二：寻找链表中点 + 链表逆序 + 合并链表
     * 注意到目标链表即为将原链表的左半端和反转后的右半端合并后的结果。
     *
     * 这样我们的任务即可划分为三步：
     *
     * 找到原链表的中点（参考「876. 链表的中间结点」）。
     *
     * 我们可以使用快慢指针来 O(N)O(N) 地找到链表的中间节点。
     * 将原链表的右半端反转（参考「206. 反转链表」）。
     *
     * 我们可以使用迭代法实现链表的反转。
     * 将原链表的两端合并。
     *
     * 因为两链表长度相差不超过 11，因此直接合并即可。
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }

//      找到原链表的中点（参考「876. 链表的中间结点」）。
        ListNode slow=head,fast=head;
        while (fast.next != null && fast.next.next != null){
            slow =slow.next;
            fast = fast.next.next;
        }

//      将原链表的右半端反转（参考「206. 反转链表」）。
        ListNode mid = slow.next;
        slow.next = null;

        ListNode dump = new ListNode(0,null);
        ListNode p = mid;

        while (p != null){
            ListNode pPost = p.next;
            p.next = dump.next;
            dump.next = p;

            p = pPost;
        }

//      将原链表的两端合并。
        fast = head;
        p = dump.next;

        while (fast != null || p != null){

            ListNode fastTemp = fast.next;
            ListNode pTemp = p.next;

            fast.next = p;
            p.next =fastTemp;

            fast = fastTemp;
            p = pTemp;
        }

        return;
    }
}
