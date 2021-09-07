package com.leetcode;

import java.util.*;

public class FrequencySort {
    public String frequencySort(String s){
        Map<Character, Integer> characterIntegerHashMap = new HashMap<>();

        int length = s.length();
        for (int i = 0; i < length; i++) {
            characterIntegerHashMap.put(s.charAt(i),characterIntegerHashMap.getOrDefault(s.charAt(i),0)+1);
        }

        List<Character> list = new ArrayList<>(characterIntegerHashMap.keySet());

        Collections.sort(list,(a,b)->characterIntegerHashMap.get(a) - characterIntegerHashMap.get(b));

        StringBuffer stringBuffer = new StringBuffer();

        for (Character character : list) {
            Integer integer = characterIntegerHashMap.get(character);

            for (int i = 0; i < integer; i++) {
                stringBuffer.append(character);
            }
        }


        return stringBuffer.reverse().toString();

    }
}
