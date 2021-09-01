package com.leetcode;

public class DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }

        int val = root.val;
        if (val < key){
            root.right = deleteNode(root.right,key);
        }else if (val > key){
            root.left = deleteNode(root.left,key);
        }else {

            if (root.left == null && root.right == null){
                root = null;
            }else if (root.right != null){
                root.val = successor(root);
                root.right = deleteNode(root.right,root.val);
            }else {
                root.val = preSuccessor(root);
                root.left = deleteNode(root.left,root.val);
            }

        }

        return root;
    }

    //successor 代表当前节点的后继（升序中紧邻的后一个节点）
    public int successor(TreeNode root){
        root=root.right;
        while (root.left != null) {
            root =root.left;
        }

        return root.val;
    }
    //preSuccessor 代表当前节点的前驱（升序中紧邻的前一个节点）
    public int preSuccessor(TreeNode root){

        root =root.left;

        while (root.right != null){
            root = root.right;
        }
        return root.val;
    }
}
