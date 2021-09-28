package com.offer.n_32;

public class LongestValidParentheses {
    public int longestValidParentheses(String s){
        int maxAns = 0;

        int length = s.length();

        int[] dp = new int[length];

        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == ')'){
                if (s.charAt(i-1) == '('){

                    dp[i] = ( i>=2 ? dp[i-2] : 0 ) +2;
//                    这一块可能有点绕,实在看不明白可以画下图
                }else if (i-dp[i-1]>0 && s.charAt(i-dp[i-1]-1) == '('){

                    dp[i] = dp[i-1] + (i-dp[i-1] >= 2 ? dp[i-dp[i-1]-2] : 0 ) +2;
                }
            }

            maxAns = Math.max(maxAns,dp[i]);
        }

        return maxAns;
    }
}
