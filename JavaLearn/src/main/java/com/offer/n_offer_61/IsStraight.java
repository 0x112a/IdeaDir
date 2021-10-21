package com.offer.n_offer_61;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsStraight {
    public boolean isStraight(int[] nums) {
        boolean ans = true;
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;

            boolean add = set.add(nums[i]);
            if (!add) {
                return false;
            }

            max = Math.max(max,nums[i]);
            min = Math.min(nums[i],min);
        }
        if (max - min >= 5 ) ans =false;

        return ans;
    }
}
