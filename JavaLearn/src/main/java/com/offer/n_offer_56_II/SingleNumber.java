package com.offer.n_offer_56_II;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                count[i] += num & 1;
                num>>>=1;
            }
        }

        int ans = 0;

        for (int i = 0; i < 32; i++) {
            ans <<=1;
            count[31 - i] %= 3;
            ans |= count[31 - i];
        }
        return ans;
    }
}
