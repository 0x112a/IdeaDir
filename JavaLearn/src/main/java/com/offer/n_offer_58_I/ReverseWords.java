package com.offer.n_offer_58_I;

public class ReverseWords {
    public String reverseWords(String s) {
        String[] s1 = s.trim().split(" ");

        StringBuilder ans = new StringBuilder();
        for (int i = s1.length-1; i >= 0; i--) {
            if ("".equals(s1[i])) continue;
            ans.append(s1[i]+" ");
        }

        return ans.toString().trim();
    }
}
