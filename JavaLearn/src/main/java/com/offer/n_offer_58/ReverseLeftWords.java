package com.offer.n_offer_58;

public class ReverseLeftWords {
    public String reverseLeftWords(String s,int n){
        int len = s.length();
        String ans;

        ans = s.substring(n,len) + s.substring(0,n);

        return ans;
    }
}
