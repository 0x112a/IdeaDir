package com.offer.n_offer_21;

public class Exchange {
    public int[] exchange(int[] nums) {
        int len = nums.length ;
        int right = len-1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] % 2 == 0){
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                i--;
                right--;
            }
        }

        return nums;
    }
}
