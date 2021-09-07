package com.leetcode;

public class KthSmallest {
    private int t;
    private int ans;

    public int kthSmallest(TreeNode root, int k){

        this.t = k;
        midOrder(root);

        return ans;
    }
    public void midOrder(TreeNode root){
        if (root.left != null){
            midOrder(root.left);
        }
        if (t == 0){
            ans = root.val;
        }
        if (root.right != null ){
            midOrder(root.right);
        }
        t--;
    }
}
