package com.leetcode;

import java.util.ArrayList;
import java.util.List;

class BSTIterator {
    List<Integer> list = new ArrayList<>();
    int index = 0;

    public BSTIterator(TreeNode root) {
        inOrder(root);
    }

    public int next() {

        return list.get(index++);
    }

    public boolean hasNext() {

        return index < list.size();
    }
    private void inOrder(TreeNode root){
        if (root == null){
            return;
        }

        inOrder(root.left);

        list.add(root.val);

        inOrder(root.right);

        return;
    }
}
