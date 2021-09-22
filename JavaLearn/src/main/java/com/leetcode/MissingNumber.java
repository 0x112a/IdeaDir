package com.leetcode;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums){
        Arrays.sort(nums);

        int length = nums.length;
        if (nums[length -1] != length){
            return length;
        }
        if (nums[0] != 0){
            return 0;
        }

        for (int i = 1; i < length ; i++) {

            if (i != nums[i]){
                return i;
            }
        }


        return -1;
    }
}
