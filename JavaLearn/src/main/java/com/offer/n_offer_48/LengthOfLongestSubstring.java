package com.offer.n_offer_48;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int ans = 0;

        int[] dp = new int[len];
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            Integer orDefault = map.getOrDefault(s.charAt(i),-1);
            map.put(s.charAt(i),i);

            if (i != 0){
                dp[i] = dp[i-1] < i-orDefault ? dp[i-1] + 1 : i-orDefault;
            }else {
                dp[i] = 1;
            }

            ans = Math.max(dp[i],ans);

        }


        return ans;
    }
}
