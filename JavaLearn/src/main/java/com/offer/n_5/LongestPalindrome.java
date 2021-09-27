package com.offer.n_5;

public class LongestPalindrome {
    public String longestPalindrome(String s){
        int length = s.length();
        if (length < 2)
            return s;

        //状态转移数组
        Boolean[][] dp = new Boolean[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();

        int begin = 0,maxLen = 1;

        for (int i = 2; i <= length; i++) {
            
            for (int j = 0; j < length; j++) {
                 int tail = i + j - 1;
                 if (tail >= length){
                     break;
                 }
                 
                 if (chars[j] != chars[tail]){
                     dp[j][tail] = false;
                 }else {
                     if (tail - j < 3)
                         dp[j][tail] = true;
                     else
                        dp[j][tail] = dp[j+1][tail-1];
                 }

                 if (dp[j][tail] && tail-j+1 > begin+maxLen ){
                     maxLen = i;
                     begin=j;
                 }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
