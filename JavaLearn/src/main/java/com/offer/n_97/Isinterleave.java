package com.offer.n_97;

public class Isinterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int s3Len = s3.length();

        if (s1Len + s2Len != s3Len){
            return false;
        }

        boolean[][] dp = new boolean[s1Len+1][s2Len+1];
        dp[0][0] = true;

        for (int i = 0; i <= s1Len; i++) {
            for (int j = 0; j <= s2Len; j++) {
                if (i > 0){
                    dp[i][j] = dp[i][j] || (dp[i-1][j] && s1.charAt(i) == s3.charAt(i+j-1));
                }
                if (j > 0){
                    dp[i][j] = dp[i][j] || (dp[i][j-1] && s2.charAt(j) == s3.charAt(i+j-1));
                }
            }
        }
        return dp[s1Len][s2Len];
    }
}
