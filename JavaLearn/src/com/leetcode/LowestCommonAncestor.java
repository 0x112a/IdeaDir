package com.leetcode;

public class LowestCommonAncestor {

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p ,TreeNode q){

        dfs(root,p,q);

        return this.ans;
    }

    public boolean dfs(TreeNode root,TreeNode p, TreeNode q){
        if (root == null){
            return false;
        }
        int x = root.val;

        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);

        if (left && right ||( x == p.val || x == q.val) && (left || right)){
            this.ans = root;
        }

        return left||right|| (x == p.val || x == q.val);
    }
}
