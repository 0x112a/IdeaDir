package com.offer.n_offer_55_I;

public class IsBalance {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (depth(root.left) - depth(root.right) <= 1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;
    }
    public int depth(TreeNode root){
        if (root == null) return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}
