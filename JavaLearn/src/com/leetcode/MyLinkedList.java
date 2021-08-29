package com.leetcode;


class MyLinkedList {

    int size;

    ListNode head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.size = 0;

        head = new ListNode();
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

        if (index < 0 && index >= size){
            return -1;
        }

        ListNode p = head;

        for (int i = 0; i < index + 1; i++) {
            p=p.next;
        }

        return p.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0,val);

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

        if (index > size ){
            return;
        }

        if (index < 0){
            index = 0;
        }

        ListNode p = head;

        for (int i = 0; i < index; i++) {

            p = p.next;

        }

        ListNode temp = p.next;

        p.next = new ListNode(val,temp);

        this.size++;

        return;

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size){
            return;
        }

        ListNode p = head;

        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        size--;
        p.next = p.next.next;
    }

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */