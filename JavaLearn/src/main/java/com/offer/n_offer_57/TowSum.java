package com.offer.n_offer_57;

public class TowSum {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;

        while (left < right){
            int sum = nums[left] + nums[right];
            if (sum == target){
                return new int[]{nums[left],nums[right]};
            }else if (sum > target){
                right--;
            }else {
                left++;
            }
        }

        return null;
    }
}
