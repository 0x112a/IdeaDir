package com.offer.n_offer_46;

public class TranslateNum {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int length = s.length();
        int p=0,q=0,r=1;

        for (int i = 0; i < length; i++) {
            p = q;
            q = r;
            r += q;
            if (i == 0) continue;

            String pre = s.substring(i-1,i+1);
            if (pre.compareTo("10")<= 0 && pre.compareTo("25")>=0){
                r+=p;
            }
        }

        return r;
    }
}
