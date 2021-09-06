package com.leetcode;

import java.util.*;

public class KClosest {
    public int[][] kClosest(int[][] point , int k){
        int length = point.length;
        Map<Integer, Integer> integerIntegerHashMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int pow = point[i][0] * point[i][0] + point[i][1] * point[i][1];
            integerIntegerHashMap.put(i,pow);
        }

        List<Integer> list = new ArrayList<Integer>(integerIntegerHashMap.keySet());

        Collections.sort(list,(a,b)->integerIntegerHashMap.get(a)-integerIntegerHashMap.get(b));


        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {

            ans[i] = point[list.get(i)];
        }

        return ans;
    }
}
