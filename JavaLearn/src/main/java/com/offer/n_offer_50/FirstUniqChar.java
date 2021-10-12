package com.offer.n_offer_50;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {
    public char firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            map.put(a,map.getOrDefault(a,0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            Integer integer = map.get(a);
            if (integer == 1){
                return a;
            }
        }


        return ' ';
    }
}
