package com.offer.n_offer_53_II;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int ans = nums.length;
        int left =0, right = ans-1;

        while (left<=right){
            int mid = (left+right)/2;
            if (nums[mid] != mid){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }
}
