//package com.leetcode;

//public class AddTowNumber {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode ans = new ListNode();
//        ListNode cur ;
//        cur = ans;
//
//        int add = 0;
//
//        while (l1 != null || l2 != null  || add != 0){
//            int x = l1 != null ? l1.val : 0;
//            int y = l2 != null ? l2.val : 0;
//
//            int sum = x + y + add;
//            ListNode node = new ListNode();
//            add = sum/10;
//            node.val = sum % 10;
//
//            cur.next =node;
//            cur = cur.next;
//
//            if (l1 != null) {
//                l1 = l1.next;
//            }
//            if (l2 != null){
//                l2 = l2.next;
//            }
//
//        }
//
//        return ans.next;
//        /**
//         * // 低内存版本
//         *         // -1作为头节点,数据结构定位的一种技巧
//         *         ListNode resultLode = new ListNode(-1);
//         *         ListNode pre = resultLode;
//         *         // 以两个节点的短路或作为循环条件
//         *         int sum = 0;
//         *         while(l1 != null || l2 != null || sum != 0){
//         *             if(l1 != null){
//         *                 // 是累加值,不是赋值!
//         *                 sum += l1.val;
//         *                 l1 = l1.next;
//         *             }
//         *             if(l2 != null){
//         *                 sum += l2.val;
//         *                 l2 = l2.next;
//         *             }
//         *             pre.next = new ListNode(sum % 10);
//         *             pre = pre.next;
//         *             sum = sum/10 > 0 ? 1 : 0;
//         *         }
//         *         return resultLode.next;
//         */
//    }
//}
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
