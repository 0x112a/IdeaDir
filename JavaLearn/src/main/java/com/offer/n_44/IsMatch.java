package com.offer.n_44;

public class IsMatch {
    public boolean isMatch(String s, String p) {

        int sLen = s.length();
        int pLen = p.length();

        boolean[][] dp = new boolean[sLen + 1][pLen + 1];

        //s and p is empty
        //只初始化true的情况
        dp[0][0] = true;

        for (int i = 1; i <= pLen; i++) {
            if (p.charAt(i-1) == '*'){
                dp[0][i] = true;
            }else {
                break;
            }
        }

        //状态转移
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }else if (p.charAt(j-1) == '?' || s.charAt(i-1)== p.charAt(j-1) ){
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }

        return dp[sLen][pLen];
    }
}
