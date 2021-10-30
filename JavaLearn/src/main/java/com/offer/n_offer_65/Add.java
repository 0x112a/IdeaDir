package com.offer.n_offer_65;

public class Add {
    public int add(int a, int b) {
        while (b != 0){
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }

        return a;
    }
}
