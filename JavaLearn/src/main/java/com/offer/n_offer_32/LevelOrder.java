package com.offer.n_offer_32;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> arrayList = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode pop = queue.poll();
            arrayList.add(pop.val);

            if (pop.left != null){
                queue.add(pop.left);
            }
            if (pop.right != null){
                queue.add(pop.right);
            }
        }

        int size = arrayList.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = arrayList.get(i);
        }

        return ans;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
