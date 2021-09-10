package com.leetcode;

public class MaxSubArray {
    public int maxSubArray(int[] nums){
        return findMaxSubArray(nums,0,nums.length-1);
    }

    public int findMaxSubArray(int[] nums,int left,int right){
        if (left == right){
            return nums[left];
        }
        int mid = (left+right)/2;

        int maxSubArray = findMaxSubArray(nums, left, mid);
        int maxSubArray1 = findMaxSubArray(nums, mid + 1, right);
        int maxCrossingSubArray = crossingSubArray(nums, left, mid, right);

        return Math.max(Math.max(maxSubArray,maxSubArray1),maxCrossingSubArray);

    }

    public int crossingSubArray(int[] nums,int left, int mid,int right){
        int minGard = Integer.MIN_VALUE;
        int sum =0;

        for (int i = mid; i >= left; i--) {
            int temp = sum + nums[i];
            if (temp >= minGard){
                minGard =temp;
                sum=temp;
            }else {
                break;
            }
        }
        minGard = Integer.MIN_VALUE;
        for (int i = mid+1; i <= right; i++) {
            int temp = sum + nums[i];
            if (temp >= minGard){
                minGard =temp;
                sum=temp;
            }else {
                break;
            }
        }

        return sum;
    }
}
