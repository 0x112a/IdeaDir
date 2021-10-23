package com.offer.n_offer_55;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public int maxDepth(TreeNode root) {

        return depth(root);
    }

    public int depth(TreeNode root){
        int maxDepth = 0;
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{add(root);}};
        while (queue.size() > 0){
            int size = queue.size();
            maxDepth++;
            while (size>0){
                TreeNode poll = queue.poll();
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
                size--;
            }
        }
        return maxDepth;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}
