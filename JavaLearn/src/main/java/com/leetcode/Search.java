package com.leetcode;

public class Search {
    public int search(int[] nums,int target){

        int length = nums.length-1;
        if (length < 0){
            return -1;
        }
        int left = 0,right=length;

        while (left<=right){
            int mid = (left+right)/2;
            int num = nums[mid];
            if (num == target){
                return mid;
            }else if (num < target){
                left = mid+1;
            }else {
                right = mid -1;
            }
        }
        return -1;
    }
}
