package com.offer.n_42;

public class Trap {
    public int trap(int[] height) {
        int l = height.length;

        if (l < 3) return 0;

        int[] leftMax = new int[l];
        int[] rightMax = new int[l];
        leftMax[0] = height[0];
        rightMax[l-1] = height[l-1];

        for (int i = 1; i < l; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
            rightMax[l-1-i] = Math.max(rightMax[l-i],height[l-i-1]);
        }
        int ans =0;

        for (int i = 0; i < l; i++) {
            ans += Math.min(leftMax[i],rightMax[i]) - height[i];
        }


        return ans;
    }
}
