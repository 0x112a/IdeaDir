package com.offer.n_offer_32_II;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeverOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<Queue<TreeNode>> queue = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        if (root != null) queue.add(new LinkedList<TreeNode>(){{add(root);}});

        while (!queue.isEmpty()){
            Queue<TreeNode> poll = queue.poll();
            List<Integer> levelList = new LinkedList<>();
            Queue<TreeNode> levelDeque = new LinkedList<>();
            while (!poll.isEmpty()){
                TreeNode poll1 = poll.poll();
                levelList.add(poll1.val);
                if (poll1.left != null){
                    levelDeque.add(poll1.left);
                }
                if (poll1.right != null){
                    levelDeque.add(poll1.right);
                }
            }
            if (levelList.size() != 0){
                ans.add(levelList);
            }
            if (levelDeque.size() != 0){
                queue.add(levelDeque);
            }
        }

        return ans;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
