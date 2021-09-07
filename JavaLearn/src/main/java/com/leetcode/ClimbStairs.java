package com.leetcode;

public class ClimbStairs {
    public int climbStairs(int n){

        //滚动数组
        int q=0,p=0,cur=1;
        for (int i =1 ; i <= n; i++) {
            q=p;
            p=cur;
            cur=p+q;
        }

        return cur;
    }
}
