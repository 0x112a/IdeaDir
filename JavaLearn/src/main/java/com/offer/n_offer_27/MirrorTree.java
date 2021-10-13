package com.offer.n_offer_27;

public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {

        swap(root);
        return root;
    }
    void swap(TreeNode root){
        if (root == null){
            return;
        }
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        swap(root.left);
        swap(root.right);
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}
