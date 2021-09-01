package com.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PathSum {

    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        DFS(root,targetSum);

        return ans;
    }

    public void DFS(TreeNode node, int sum){
        if (node == null){
            return;
        }

        int val = node.val;
        path.addLast(val);
        if (sum - val == 0 && node.right == null && node.left == null){
            ans.add(new ArrayList<>(path));
        }

        DFS(node.left,sum-val);
        DFS(node.right,sum-val);

        path.pollLast();
        return;
    }
}
