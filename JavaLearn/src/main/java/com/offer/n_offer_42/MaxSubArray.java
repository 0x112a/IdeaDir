package com.offer.n_offer_42;

public class MaxSubArray {
//    分治
    public int maxSubArray(int[] nums) {
        int len = nums.length;

        return findMaxSubArray(nums,0,len-1);
    }

    public int findMaxSubArray(int[] nums,int left, int right){
        if (left == right) return nums[left];

        int mid = (left+right)/2;

        int maxLeftSubArray = findMaxSubArray(nums, left, mid);
        int maxRightSubArray = findMaxSubArray(nums, mid + 1, right);
        int maxCrossSubArray = crossMaxValue(nums, left, mid, right);


        return Math.max(Math.max(maxLeftSubArray,maxRightSubArray),maxCrossSubArray);
    }

    public int crossMaxValue(int[] nums,int left, int mid, int right){

        int sum = 0;
        int maxLeft = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sum = sum+nums[i];
            if (sum > maxLeft){
                maxLeft = sum;
            }
        }

        sum = 0;
        int maxRight = Integer.MIN_VALUE;
        for (int i = mid+1; i <= right; i++) {
            sum += nums[i];
            if (sum > maxRight){
                maxRight = sum;
            }
        }

        return maxLeft+maxRight;
    }
}
