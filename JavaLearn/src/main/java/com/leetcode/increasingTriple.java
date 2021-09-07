package com.leetcode;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;

public class increasingTriple {
    public boolean increasingTriplet(int[] nums){
        int n = nums.length;
        if (n < 3){
            return false;
        }
        int Min = Integer.MAX_VALUE,postMin = Integer.MAX_VALUE;

        for (int i =0 ; i<n; i++){
            if (nums[i]<Min){
                Min = nums[i];
            }else if (nums[i]<postMin){
                postMin = nums[i];
            }else {
                return true;
            }

        }
        return false;
    }
}
