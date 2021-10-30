package com.offer.n_offer_66;

public class ConstrucArr {
    public int[] constructArr(int[] a) {
        int length = a.length;
        if (length == 0) return a;
        int[] prefix = new int[length];
        int[] postfix = new int[length];
        int[] ans = new int[length];
        prefix[0] = 1;
        postfix[length-1] = 1;

        for (int i = 1; i < length ; i++){
            prefix[i] = a[i-1] * prefix[i-1];
            postfix[length - i - 1] = postfix[length - i ]* a[length - i];
        }

        for (int i = 0; i < length; i++) {
            ans[i] = prefix[i] * postfix[i];
        }

        return ans;
    }
}
