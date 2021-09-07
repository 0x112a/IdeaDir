package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j < length; j++) {
                if (j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int left = j+1,right = length-1;
                int temp = (target-nums[i]-nums[j]);
                while (left < right){
                    int t = nums[left] + nums[right];
                    if (t == temp){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (left < right && nums[left] == nums[left+1]){
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right-1]){
                            right--;
                        }
                        right--;
                    }else if (t < temp){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
