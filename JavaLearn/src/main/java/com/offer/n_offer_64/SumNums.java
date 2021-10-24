package com.offer.n_offer_64;

public class SumNums {
    public int sumNums(int n) {
        boolean x = n>1 && (n += sumNums(n-1)) > 0;
        return n;
    }
}
