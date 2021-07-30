package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class wordPattern {
    public boolean wordPattern(String pattern,String s){
//        String[] s1 = s.split(" ");
//        int n = pattern.length();
//        if (s1.length != n){
//            return false;
//        }
//        Map<Character, List<Integer>> map = new HashMap<>();
//
//        for (int i=0; i< n ;i++){
//            if (map.get(pattern.charAt(i)) == null){
//                map.put(pattern.charAt(i),new ArrayList<>(i));
//                continue;
//            }
//            map.get(pattern.charAt(i)).add(i);
//        }
//        for(int i = 97;i<123; i++){
//            char[] chars = Character.toChars(i);
//            if (map.get(chars)==null){
//                continue;
//            }
//        }

        //即任意一个字符都对应着唯一的字符串，任意一个字符串也只被唯一的一个字符对应。在集合论中，这种关系被称为「双射」。
        Map<String,Character> str = new HashMap<String,Character>();
        Map<Character, String> ch = new HashMap<Character,String>();
        int n = s.length();
        int i = 0;
        for (int p = 0; p < pattern.length();p++){
            char c = pattern.charAt(p);
            if (i >=n){
                return false;
            }
            int j = i;
            while (j<n && s.charAt(j) != ' '){
                j++;
            }

            String tmp = s.substring(i, j);
            if (str.containsKey(tmp) && str.get(tmp) != c){
                return false;
            }
            if (ch.containsKey(c) && !tmp.equals(ch.get(c))){
                return false;
            }
            str.put(tmp,c);
            ch.put(c,tmp);
            i = j+1;

        }
        return i >= n;

    }
}
