package com.offer.n_offer_63;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;

        if (len == 0) return 0;

        int[] dp = new int[len];
        //边界条件
        dp[0] = 0;
        int nowMinPrice = prices[0];

        for (int i = 1; i < len; i++) {

            nowMinPrice = Math.min(nowMinPrice, prices[i]);
            dp[i] = Math.max(dp[i-1],prices[i] - nowMinPrice);
        }

        return dp[len-1];
    }
}
