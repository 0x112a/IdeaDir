package com.leetcode;

public class subarraySum {
    public int subarraySum(int[] nums, int k){
//         内存超限
//        int n = nums.length;
//        int ans = 0;
//
//        if (n ==1 && nums[0] != k){
//            return 0;
//        }
//
//        int[][] dp = new int[n+1][];
//        int dpLength = dp.length;
//        for (int i = 0; i< dpLength; i++) {
//            dp[i] = new int[i+1];
//        }
//
//        for (int i = 0; i< dpLength; i++){
//            for(int j= i+1;j<dpLength;j++){
//                //System.out.printf("%d %d\n",i,j);
//                dp[j][i] = dp[j-1][i]+nums[j-1];
//                if (dp[j][i] == k){
//                    ans++;
//                }
//            }
//        }
//
//        return ans;
        int n = nums.length;
        int ans = 0;

        for (int start = 0; start<n;start++){
            int sumTemp =0;
            for (int end = start; end<n;end++){
                sumTemp+=nums[end];
                if (sumTemp==k){
                    ans++;
                }
            }
        }
        return ans;


    }
}
