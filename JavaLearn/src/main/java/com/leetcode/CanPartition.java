package com.leetcode;

public class CanPartition {
    public boolean canPartition(int[] nums){
        int length = nums.length;
        if (length < 2){
            return false;
        }

        int sum=0,maxNum=0;

        for (int num : nums) {
            sum+=num;
            maxNum = Math.max(num,maxNum);
        }

        if (sum%2!=0){
            return false;
        }
        int half = sum / 2;
        if (half < maxNum){
            return false;
        }

        boolean[][] dp = new boolean[length][half+1];
        for (int i = 0; i < length; i++) {
            dp[i][0]=true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            for (int j = 1; j <= half; j++) {
                if (j >= num){
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-num];
                }else {
                    dp[i][j] = dp[i-1][j];
                }

            }
            
        }
        return dp[length-1][half];
    }
}
