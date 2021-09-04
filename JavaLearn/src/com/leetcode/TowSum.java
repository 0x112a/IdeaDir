package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TowSum {
    public int[] towSum(int[] nums, int target){
//        第一
//        Map<Integer, Integer> map = new HashMap<>();
//        int length = nums.length;
//        for (int i = 0; i < length; i++) {
//            Integer orDefault = map.getOrDefault(nums[i], -1);
//            if (orDefault == -1){
//                map.put(target - nums[i],i);
//            }else {
//                return new int[]{orDefault,i};
//            }
//        }
//        return new int[2];
//        第二
        int length = nums.length;
        int left = 0,right = length-1;

        while (left < right){
            int sum = nums[left] + nums[right];
            if (sum == target){
                return new int[]{left,right};
            }else if (sum < target){
                left++;
            }else {
                right++;
            }
        }

        return new int[]{};

    }

}
