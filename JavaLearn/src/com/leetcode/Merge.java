package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                返回值是一个整数，负数代表小，0 相等，整数代表啊大——相对于第二个数
                return o1[0] - o2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i<intervals.length;i++){
            int left = intervals[i][0],right = intervals[i][1];

            if (merged.size() == 0 || merged.get(merged.size()-1)[1] < left){
                merged.add(new int[]{left,right});
            }else {
                merged.get(merged.size()-1)[1] = Math.max(right,merged.get(merged.size()-1)[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
