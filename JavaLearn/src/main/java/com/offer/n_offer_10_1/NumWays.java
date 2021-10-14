package com.offer.n_offer_10_1;

public class NumWays {
    public int numWays(int n) {
        final int MOD = 1000000007;
        if (n < 2) return n;

        int p = 0, q = 1, r = 1;

        for (int i = 1; i < n; i++) {
            p = q;
            q = r;
            r = (p+q) % MOD;
        }

        return r;
    }
}
