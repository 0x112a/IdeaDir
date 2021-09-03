package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeC {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        return preOrderSerialize(root,"");
    }

    private String preOrderSerialize(TreeNode root, String s) {
        if (root==null){
            s += "none,";
            return s;
        }
        s +=root.val + ",";
        s = preOrderSerialize(root.left,s);
        s = preOrderSerialize(root.right,s);
        
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] split = data.split(",");

        List<String> dataList = new ArrayList<>(Arrays.asList(split));

        return preOrderDeserialize(dataList);
    }

    private TreeNode preOrderDeserialize(List<String> dataList) {
        if (dataList.get(0) == "none"){
            dataList.remove(0);
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);

        node.left = preOrderDeserialize(dataList);
        node.right = preOrderDeserialize(dataList);

        return node;
    }
}
