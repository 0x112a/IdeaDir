package com.offer.n_offer_54;

public class KthLargest {
    int k,cur = 0,ans;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        rePostOrder(root);
        return ans;
    }
    public void rePostOrder(TreeNode root){
        if (root == null) return ;
        rePostOrder(root.right);
        cur++;
        if (cur == k) ans = root.val;
        rePostOrder(root.left);

        return;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
