package com.offer.n_offer_45;

public class MinNumber {
    public String minNumber(int[] nums) {
        int len = nums.length;
        String[] str = new String[len];
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        //冒泡排序
        boolean hasChange = true;
        for (int i = 0; i < len-1 && hasChange; i++) {
            hasChange = false;
            for (int j = 0; j < len - i - 1; j++) {
                String s1 = str[j] + str[j + 1];
                String s2 = str[j + 1] + str[j] ;
                if (s1.compareTo(s2) > 0){
                    swap(str,j,j+1);
                    hasChange = true;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (String s : str) {
            ans.append(s);
        }

        return ans.toString();

    }

    private void swap(String[] nums, int j, int i) {
        String temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        return;
    }

}
