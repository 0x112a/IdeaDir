package com.offer.n_offer_10;

public class Fib {
    public int fib(int n) {
//        内存超限 -- 递归不合适
//        if (n == 0 || n == 1) return n == 0 ? 0 : 1;
//        return fib(n-1)+fib(n-2);
        final int MOD = 1000000007;
        if (n < 2) return n;

        int p = 0, q = 0, r = 1;
        for (int i = 1; i < n; i++) {
            p = q;
            q = r;
            r = (p+q) % MOD;
        }
        return r;
    }


}
