package com.leetcode;

import java.util.HashMap;

public class BuildTree {
    private HashMap<Integer, Integer> hashMap;
    public TreeNode buildTree(int[] preorder,int[] inorder){
        int length = inorder.length;

         hashMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            hashMap.put(inorder[i],i);
        }

        return myBuildTree(preorder,inorder,0,length-1,0,length-1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight){
            return null;
        }

        //获取根节点的值
        int val = preorder[preLeft];

        TreeNode root = new TreeNode(val);

        //获取根节点在中序遍历中的节点
        Integer mid = hashMap.get(val);

        //获得左子树的个数
        int leftSubTreeCount = mid - inLeft;

        //传入参数值不能改变
//        //先序遍历往前走
//        preLeft++;

        //构建左子树
        root.left = myBuildTree(preorder,inorder,preLeft+1,preLeft+leftSubTreeCount,inLeft,mid-1);

        //构建右子树
        root.right = myBuildTree(preorder,inorder,preLeft+leftSubTreeCount+1,preRight,mid+1,inRight);

        return root;
    }
}
