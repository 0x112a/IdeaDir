package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            Integer orDefault = map.getOrDefault(i,0);
            map.put(i,orDefault+1);
        }

        int i = 1;
        while (true){
            if (map.getOrDefault(i,0) == 0){
                break;
            }
            i++;
        }

        return i;
    }
}
