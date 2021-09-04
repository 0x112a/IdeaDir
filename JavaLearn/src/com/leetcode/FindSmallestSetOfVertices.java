package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindSmallestSetOfVertices {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        List<Integer> ans = new ArrayList<>();
        int[] arr = new int[n];

        for (int i = 0; i < edges.size(); i++) {
            arr[edges.get(i).get(1)]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0){
                ans.add(i);
            }
        }

        return ans;
    }
}
