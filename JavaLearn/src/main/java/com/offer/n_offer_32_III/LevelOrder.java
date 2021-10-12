package com.offer.n_offer_32_III;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if (root != null){
            queue.add(root);
        }

        boolean direct = false;

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            if (direct){
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.pollFirst();
                    level.add(poll.val);
                    if (poll.left != null){
                        queue.offerLast(poll.left);
                    }
                    if (poll.right != null){
                        queue.offerLast(poll.right);
                    }
                }
            }else {
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.pollLast();
                    level.add(poll.val);
                    if (poll.right != null){
                        queue.offerFirst(poll.right);
                    }
                    if (poll.left != null){
                        queue.offerFirst(poll.left);
                    }
                }
            }
            direct = !direct;
            ans.add(level);
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