package com.leetcode;

import java.util.Map;

public class longestPalindrome {
    public int longestPalindrome(String s){
        int[] count = new int[128];
        int n = s.length();
        for (int i = 0; i < n; i++){
            char temp = s.charAt(i);
            count[temp]++;
        }
        
        int ans = 0;
        for (int i : count) {
            ans+=i/2*2;
            if (i%2 == 1 && ans % 2 ==0){
                ans++;
            }
        }
        return ans;
    }
}
