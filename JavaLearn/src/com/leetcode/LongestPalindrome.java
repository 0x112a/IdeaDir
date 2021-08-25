package com.leetcode;


public class LongestPalindrome {
    public String longestPalindrome(String s){
//        int[] count = new int[128];
//        int n = s.length();
//        for (int i = 0; i < n; i++){
//            char temp = s.charAt(i);
//            count[temp]++;
//        }
//
//        int ans = 0;
//        for (int i : count) {
//            ans+=i/2*2;
//            if (i%2 == 1 && ans % 2 ==0){
//                ans++;
//            }
//        }
//        return ans;

//        int[] count = new int[128];
//
//        int length = s.length();
//
//        int ans = 0;
//
//        for(int i =0; i< length; i++){
//            //存储时自动把char类型转换为int类型
//            count[s.charAt(i)]++;
//        }
//
//        for (int i : count) {
//            ans += i/2*2;
//            if(ans % 2 == 0 && i%2 ==1){
//                ans++;
//            }
//        }
//        return ans;

        /**
         * 最长回文子串
         * 给你一个字符串 s，找到 s 中最长的回文子串。
         */

        int len = s.length();
        if (len < 2){
            return s;
        }

        int maxLen = 1;
        int begin =0;

        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            //每一个字母都是回文字
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();

        for (int i = 2; i < len; i++) {

            for (int j = 0; j < len; j++) {

                int a = i + j - 1;

                if (a >= len){
                    break;
                }

                if (chars[j] != chars[a]){
                    dp[j][a] = false;
                }else{
                    if (a-j < 3){
                        dp[j][a] = true;
                    }else {
                        dp[j][a] = dp[j+1][a-1];
                    }
                }

                if (dp[j][a] && a-j+1 > maxLen){
                    maxLen = a-j+1;
                    begin=j;
                }
            }

        }

        return s.substring(begin,begin+maxLen);
    }
}
