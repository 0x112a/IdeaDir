package com.leetcode;

import java.util.HashMap;

public class SubarraySum {
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
        //枚举
//        int n = nums.length;
//        int ans = 0;
//
//        for (int start = 0; start<n;start++){
//            int sumTemp =0;
//            for (int end = start; end<n;end++){
//                sumTemp+=nums[end];
//                if (sumTemp==k){
//                    ans++;
//                }
//            }
//        }
//        return ans;

        //前缀和
        int length = nums.length;
        int ans = 0;
        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for (int i = 0; i< length; i++){
            pre+=nums[i];
            if (map.containsKey(pre-k)){
                ans += map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return ans;
    }
}
