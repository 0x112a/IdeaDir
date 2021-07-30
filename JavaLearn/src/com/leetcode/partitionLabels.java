package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class partitionLabels {
    public List<Integer> partitionLabels(String s){

        //贪心算法
        int[] last = new int[26];
        int n = s.length();

        for (int i=0; i<n; i++){
            last[s.charAt(i)-'a'] = i;
        }

        List<Integer> ans = new ArrayList<Integer>();

        int start=0,end=0;
        for (int i=0;i<n ; i++){
            end = Math.max(end,last[s.charAt(i)-'a']);
            if (end==i){
                ans.add(end-start+1);
                start=end+1;
            }

        }

        return ans;
    }
}
