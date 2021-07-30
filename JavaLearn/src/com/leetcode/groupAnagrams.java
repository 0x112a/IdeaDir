package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] str){
        Map<String, List<String>> ans = new HashMap<>();
        for (String s : str) {
            int[] count = new int[26];
            int n = s.length();
            for (int i = 0; i < n; i++){
                count[s.charAt(i)-'a']++;
            }

            StringBuffer sub = new StringBuffer();
            for (int i = 0; i < 26; i++){
                if (count[i]!=0){
                    sub.append((char)(i+'a'));
                    sub.append(count[i]);
                }
            }
            String key = sub.toString();
            List<String> list = ans.getOrDefault(key, new ArrayList<>());
            list.add(s);
            ans.put(key,list);
        }

        return new ArrayList<List<String>>(ans.values());
    }
}
