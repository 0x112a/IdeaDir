package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) return 0;

        //升序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int right = intervals[0][1];
        int ans = 1;


        for (int i = 1; i < len; i++){
            if (intervals[i][0] >= right){
                ans++;
                right=intervals[i][1];
            }
        }
        return len-ans;
    }
}
