package com.offer.n_offer_16;


public class Mypow {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        long b = n;

        if (n < 0){
            x = 1/x;
            b = -b;
        }

        double sum = 1;
        while (b>0){
            if ((b & 1) == 1) sum *= x;
            x *= x;
            b>>=1;
        }

        return sum;
    }
}
