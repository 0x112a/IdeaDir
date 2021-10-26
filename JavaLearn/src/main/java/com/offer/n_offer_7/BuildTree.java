package com.offer.n_offer_7;

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode ans = preMidCreateBiTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);

        return ans;
    }

    public TreeNode preMidCreateBiTree(int[] preOrder,int[] midOrder,int preLeft,int preRight,int midLeft, int midRight){
        if (preLeft > preRight) return null;
        //先序遍历的第一个节点为根节点，取出值后加一
        int x = preOrder[preLeft];
        preLeft++;

        //构建根节点
        TreeNode node = new TreeNode(x);
        int index = 0;
        for (int i = midLeft; i <= midRight; i++) {
            if (midOrder[i] == x) break;
            index++;
        }

        node.left = preMidCreateBiTree(preOrder,midOrder,preLeft,preLeft+index-1,midLeft,midLeft+index-1);
        node.right = preMidCreateBiTree(preOrder,midOrder,preLeft+index, preRight,midLeft+index+1,midRight);

        return node;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x;}
}
