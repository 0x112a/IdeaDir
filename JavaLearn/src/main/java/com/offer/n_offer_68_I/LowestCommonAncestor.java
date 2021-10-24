package com.offer.n_offer_68_I;

public class LowestCommonAncestor {
    private TreeNode ans;

    public LowestCommonAncestor() {
        this.ans = null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        existSonNode(root,p,q);
        return ans;
    }
    public boolean existSonNode(TreeNode root,TreeNode p, TreeNode q){
        if (root == null ) return false;
        boolean lSon = existSonNode(root.left,p,q);
        boolean rSon = existSonNode(root.right,p,q);

        if (lSon && rSon || (root.val == p.val || root.val == q.val) && (lSon || rSon)){
            ans = root;
        }

        return lSon || rSon ||(root.val == q.val || root.val == p.val);
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}
