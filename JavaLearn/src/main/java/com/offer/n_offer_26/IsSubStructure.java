package com.offer.n_offer_26;

public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    boolean recur(TreeNode a, TreeNode b){
        if (b == null) return true;
        if (a == null || a.val != b.val) return false;

        return recur(a.left,b.left) && recur(a.right,b.right);
    }
}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;}
}