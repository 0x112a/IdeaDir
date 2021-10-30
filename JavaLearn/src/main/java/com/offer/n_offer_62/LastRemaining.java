package com.offer.n_offer_62;

public class LastRemaining {
    public int lastRemaining(int n, int m) {
        int x =0;
        for (int i = 2; i <=n; i++) {
            x = (x+m)%i;
        }

        return x;
    }
}

