package com.offer.n_offer_56_I;

public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int or = 0;
        for (int num : nums) {
            or ^= num;
        }
        int index = 1;
        while ((index & or) == 0){
            index<<=1;
        }


        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & index) != 0){
                a ^= num;
            }else {
                b ^= num;
            }
        }


        return new int[]{a,b};
    }
}
