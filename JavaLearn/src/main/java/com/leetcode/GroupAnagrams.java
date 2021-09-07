package com.leetcode;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] str){
//        Map<String, List<String>> ans = new HashMap<>();
//        for (String s : str) {
//            int[] count = new int[26];
//            int n = s.length();
//            for (int i = 0; i < n; i++){
//                count[s.charAt(i)-'a']++;
//            }
//
//            StringBuffer sub = new StringBuffer();
//            for (int i = 0; i < 26; i++){
//                if (count[i]!=0){
//                    sub.append((char)(i+'a'));
//                    sub.append(count[i]);
//                }
//            }
//            String key = sub.toString();
//            List<String> list = ans.getOrDefault(key, new ArrayList<>());
//            list.add(s);
//            ans.put(key,list);
//        }
//
//        return new ArrayList<List<String>>(ans.values());
        Map<String, List<String>> stringListHashMap = new HashMap<>();

        for (String s : str) {
            int[] count = new int[26];

            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)-'a']++;
            }

            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0){
                    stringBuffer.append((char)(i+'a'));
                    stringBuffer.append(count[i]);
                }
            }

            List<String> orDefault = stringListHashMap.getOrDefault(stringBuffer, new ArrayList<>());

            orDefault.add(s);

            stringListHashMap.put(stringBuffer.toString(),orDefault);

        }

        return new ArrayList<List<String>>(stringListHashMap.values());

    }

}
