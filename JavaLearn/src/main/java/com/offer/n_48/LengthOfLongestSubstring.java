package com.offer.n_48;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    /**
     * Error
     *
     java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
     at line 13, Solution.lengthOfLongestSubstring
     at line 57, __DriverSolution__.__helper__
     at line 82, __Driver__.main
     * @param s
     * @return
    public int  lengthOfLongestSubstring(String s){
        int ans = 0;
        int length = s.length();

        //dp[i] is s[i]  length Of Longest Substring with conflict char
        int[] dp = new int[length];

        // K is char , V is k in s last location
        Map<Character, Integer> characterIntegerHashMap = new HashMap<>();

        //边界
        dp[0] = 1;
        characterIntegerHashMap.put(s.charAt(0),0);

        for (int i = 1; i < length; i++) {

            Integer orDefault = characterIntegerHashMap.getOrDefault(s.charAt(i), -1);

            characterIntegerHashMap.put(s.charAt(i),i);

            //状态转移方程
            dp[i] = dp[i-1] < i - orDefault ? dp[i-1]+1 : i-orDefault;

            ans = Math.max(dp[i],ans);
        }

        return ans;
    }
     */
    public int lengthOfLongestSubString(String s){
        int ans = 0;
        int length = s.length();

        if (length == 0) return 0;

        int[] dp = new int[length];

        Map<Character,Integer> hashmap =  new HashMap<>();

        for (int i = 0; i < length; i++) {
            Integer orDefault = hashmap.getOrDefault(s.charAt(i), -1);

            hashmap.put(s.charAt(i),i);

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
