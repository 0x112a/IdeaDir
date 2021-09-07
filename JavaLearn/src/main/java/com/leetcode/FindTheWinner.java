package com.leetcode;

public class FindTheWinner {
    /**
     *
     递归 不是很明白


     object Solution {
     def findTheWinner(n: Int, k: Int): Int = {
     if (n == 1) n else (findTheWinner(n-1,k) + k -1) % n +1

     }
     }
     */
    public int findTheWinner(int n, int k){
        if (n == 1) return n;
        return  (findTheWinner(n-1,k)+ k -1) % n +1;
    }
}
