package com.offer.n_offer_68;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left,p,q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right,p,q);

        return root;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ this.val = x;}
}
