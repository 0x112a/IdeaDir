package com.offer.n_offer_3;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        int repeat = -1;
        Set<Integer> dic = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (!dic.add(nums[i])){
                repeat = nums[i];
                break;
            }
        }
        return repeat;
    }
}
