package com.leetcode;


public class LongestPalindrome {
    public int longestPalindrome(String s){
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

        int[] count = new int[128];

        int length = s.length();

        int ans = 0;

        for(int i =0; i< length; i++){
            //存储时自动把char类型转换为int类型
            count[s.charAt(i)]++;
        }

        for (int i : count) {
            ans += i/2*2;
            if(ans % 2 == 0 && i%2 ==1){
                ans++;
            }
        }
        return ans;
    }
}
