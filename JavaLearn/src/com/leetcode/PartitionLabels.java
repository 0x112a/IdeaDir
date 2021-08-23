package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {

        //贪心算法
        int[] lastIndex = new int[26];
        int len = s.length();

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <len; i++) {
            lastIndex[s.charAt(i)-'a']=i;
        }

        int start =0;
        int end = 0;

        for (int i = 0; i < len; i++) {
            int lastIndex1 = lastIndex[s.charAt(i) - 'a'];

            end = Math.max(lastIndex1,end);

            if (end == i){
                ans.add(end-start+1);
                start = end+1;
            }
        }

        return ans;

    }
}
