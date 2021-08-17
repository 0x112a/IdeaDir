package com.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int first = 0; first < n; first++){
            if (first > 0 && nums[first] == nums[first-1]){
                continue;
            }
            int target = -nums[first];
            //这里使用双指针减少一层循环，是复杂度在N^2
            int third = n-1;
            for (int scend = first+1; scend < n; scend++){
                if (scend > first + 1 && nums[scend] == nums[scend-1]){
                    continue;
                }
                while (scend< third && nums[scend] + nums[third] > target){
                    third--;
                }

                if ( scend == third) {
                    break;
                }

                if (nums[scend] + nums[third] == target){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[scend]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }

        }

        return ans;
    }
}
