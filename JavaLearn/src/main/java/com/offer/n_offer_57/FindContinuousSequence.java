package com.offer.n_offer_57;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        int left = 1,right =2,sum = 3;
        List<int[]> ans = new ArrayList<>();

        while (left < right){
            if (sum == target){
                int[] temp = new int[right-left+1];
                for (int i = left; i <= right ; i++) {
                    temp[i-left] = i;
                }
                ans.add(temp);
            }

            if (sum >= target){
                sum-=left;
                left++;
            }else {
                right++;
                sum+=right;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
