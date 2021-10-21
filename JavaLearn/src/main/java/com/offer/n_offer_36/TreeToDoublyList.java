package com.offer.n_offer_36;

import java.util.HashMap;
import java.util.Map;

public class TreeToDoublyList {

    Map<Integer,Node> map = new HashMap<>();
    int index = -1;

    public Node treeToDoublyList(Node root) {
        midOrder(root);

        if (map.size() == 0){
            return null;
        }

        Node node = map.get(0);
        Node pre,cur;
        pre = node;
        for (int i = 1; i <= index; i++) {
            cur = map.get(i);
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }

        pre.right = node;
        node.left = pre;

        return node;
    }

    public void midOrder(Node root){
        if (root == null) return;
        midOrder(root.left);
        map.put(++index,root);
        midOrder(root.right);
        return;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}