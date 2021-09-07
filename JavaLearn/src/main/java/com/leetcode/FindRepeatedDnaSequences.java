package com.leetcode;

import java.util.*;

public class FindRepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        int window = 10;


        Map<String, Integer> stringIntegerHashMap = new HashMap<>();
        HashSet<String> ans = new HashSet<>();

        for (int i = 0; i < len-10; i++) {
            String substring = s.substring(i, i + window);

            Integer orDefault = stringIntegerHashMap.getOrDefault(substring, 0);

            int temp = orDefault + 1;
            if (temp > 1) {
                ans.add(substring);
            }
            stringIntegerHashMap.put(substring, temp);
        }

        return new ArrayList<String>(ans);
    }
}
