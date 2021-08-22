package com.leetcode;

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3){
            return false;
        }

        int min = Integer.MAX_VALUE,minPost = Integer.MAX_VALUE;

        for (int i = 0; i< len; i++){
            if (nums[i] <= min){
                min = nums[i];
            }else if(nums[i] <= minPost){
                minPost = nums[i];
            }else{
                return true;
            }
        }

        return false;
    }
}
