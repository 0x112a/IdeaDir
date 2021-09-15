package com.intoan;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("String",12);
        hm.put(new String("String"),12);

        System.out.println(hm);
    }
}
