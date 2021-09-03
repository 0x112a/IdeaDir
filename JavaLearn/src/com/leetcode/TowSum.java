package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TowSum {
    public int[] towSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            Integer orDefault = map.getOrDefault(nums[i], -1);
            if (orDefault == -1){
                map.put(target - nums[i],i);
            }else {
                return new int[]{orDefault,i};
            }
        }
        return new int[2];
    }

}
