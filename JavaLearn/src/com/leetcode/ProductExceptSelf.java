package com.leetcode;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] l = new int[len];
        int[] r = new int[len];
        int[] ans = new int[len];
        l[0] = 1;
        r[len-1] = 1;

        for (int i = 1; i < len; i++){
            l[i] = l[i-1] * nums[i-1];
            int temp = len - i - 1;
            r[temp] = r[temp+1] * nums[temp+1];
        }

        for (int i = 0; i< len ; i++){
            ans[i] = l[i] * r[i];
        }
        return ans;
    }
}
