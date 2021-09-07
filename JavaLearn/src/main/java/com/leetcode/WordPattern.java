package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern,String s){
//        Error
//        "abba"
//        "dog dog dog dog"
//        String[] s1 = s.split(" ");
//        int n = pattern.length();
//        int len = s1.length;
//        if (len != n){
//            return false;
//        }
//        Map<Character, String> map = new HashMap<>();
//
//        for (int i=0; i< n ;i++){
//            if (map.get(pattern.charAt(i)) == null){
//                map.put(pattern.charAt(i),s1[i]);
//                continue;
//            }
//            String s2 = map.get(pattern.charAt(i));
//
//            System.out.println(s2 + "@" + s1[i]);
//            if (!s2.equals(s1[i])){
//                return false;
//            }
//        }
//        return true;

        String[] s1 = s.split(" ");
        int n = pattern.length();
        int len = s1.length;
        if (len != n){
            return false;
        }
//        采用双射
        Map<Character, String> pTos = new HashMap<>();
        Map<String,Character> sTop = new HashMap<>();

        for (int i=0; i< n ;i++){
            char tempC = pattern.charAt(i);
            String tempS = s1[i];

            if (pTos.containsKey(tempC) && pTos.get(tempC).equals(tempS)){
                return false;
            }

            if (sTop.containsKey(tempS) && sTop.get(tempS).equals(tempC)){
                return false;
            }

            sTop.put(tempS,tempC);
            pTos.put(tempC,tempS);
            System.out.println(sTop.toString() +"@"+ pTos.toString());
        }
        return true;
        //即任意一个字符都对应着唯一的字符串，任意一个字符串也只被唯一的一个字符对应。在集合论中，这种关系被称为「双射」。
//        Map<String,Character> str = new HashMap<String,Character>();
//        Map<Character, String> ch = new HashMap<Character,String>();
//        int n = s.length();
//        int i = 0;
//        for (int p = 0; p < pattern.length();p++){
//            char c = pattern.charAt(p);
//            if (i >=n){
//                return false;
//            }
//            int j = i;
//            while (j<n && s.charAt(j) != ' '){
//                j++;
//            }
//
//            String tmp = s.substring(i, j);
//            if (str.containsKey(tmp) && str.get(tmp) != c){
//                return false;
//            }
//            if (ch.containsKey(c) && !tmp.equals(ch.get(c))){
//                return false;
//            }
//            str.put(tmp,c);
//            ch.put(c,tmp);
//            i = j+1;
//
//        }
//        return i >= n;

    }
}
