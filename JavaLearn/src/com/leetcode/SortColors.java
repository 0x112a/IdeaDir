package com.leetcode;

public class SortColors {
    public void sortColors(int[] nums){
        int left,right,cur;
        left = 0;
        right = nums.length -1;

        for (cur = 0; cur < right;){
            System.out.println(nums.toString());
            int temp = nums[cur];
            switch (temp){
                case 0:{
                    nums[cur] = nums[left];
                    nums[left] = temp;
                    left++;
                    cur++;
                }
                case 1:{
                    cur++;
                }
                case 2:{
                    nums[cur] = nums[right];
                    nums[right] = temp;
                    right--;
                }
            }

        }
    }
}
