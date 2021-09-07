package com.leetcode;

import java.util.*;

public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Map<Integer,Integer> rightMostNodeVal = new HashMap<>();
        //维护二叉树的最大深度
        int maxDepth = -1;

        //队列先进后出,实现最后一个遍历的即为右视图所看到的
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();

        nodeQueue.add(root);
        depthQueue.add(0);

        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.remove();
            Integer depth = depthQueue.remove();

            if (node != null){
                maxDepth = Math.max(depth,maxDepth);

                rightMostNodeVal.put(depth,node.val);

                nodeQueue.add(node.left);
                nodeQueue.add(node.right);

                depthQueue.add(depth+1);
                depthQueue.add(depth + 1);
            }
        }

        for (int i = 0; i < maxDepth; i++) {
            ans.add(rightMostNodeVal.get(i));
        }

        return ans;
    }
}
