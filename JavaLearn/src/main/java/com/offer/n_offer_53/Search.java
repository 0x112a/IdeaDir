package com.offer.n_offer_53;

import java.util.HashMap;
import java.util.Map;

public class Search {
    public int search(int[] nums, int target) {
//        一般写法
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.put(num,map.getOrDefault(num,1)+1);
//        }
//        return map.getOrDefault(target,0);
//        binary search写法
        int leftInd = binSearch(nums,target,true);
        int rightInd = binSearch(nums,target,false) - 1;

        if (leftInd <= rightInd && rightInd < nums.length && nums[leftInd] == target && nums[rightInd] == target){
            return rightInd - leftInd + 1;
        }

        return 0;

    }

    /**
     * 二叉搜索查询索引位置
     * @param nums
     * @param target
     * @param low
     * @return
     */
    public int binSearch(int[] nums,int target,boolean low){
        int left = 0, right = nums.length-1, ans = nums.length;

        while (left <= right){
            int mid = (left+right)/2;

            if (nums[mid] > target || (low && nums[mid] >= target)){
                right = mid - 1;
                ans = mid;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
