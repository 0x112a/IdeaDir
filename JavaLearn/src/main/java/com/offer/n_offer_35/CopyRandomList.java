package com.offer.n_offer_35;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    Map<Node,Node> copyNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;


        while (!copyNode.containsKey(head)){

            Node cur = new Node(head.val);
            copyNode.put(head,cur);
            cur.next = copyRandomList(head.next);
            cur.random = copyRandomList(head.random);
        }


        return copyNode.get(head);
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
