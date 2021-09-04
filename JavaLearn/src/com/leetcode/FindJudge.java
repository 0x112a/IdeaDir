package com.leetcode;

public class FindJudge {
//  1、n = 1，只有法官自己，返回1就行了
//  2、定义一个n+1长度的数组。分表代表每个人。遍历二维数组。如果被别人信任+1，信任别人-1.那么这个数的最大值就是他被任何人信任，而且他不信任任何人，也就是n-1.这个人就是法官

    public int findJudge(int n, int[][] trust){
        if (n == 1){
            return 1;
        }
        int[] arr = new int[n+1];

        int length = trust.length;
        for (int i = 0; i < length; i++) {

            arr[trust[i][0]]--;
            arr[trust[i][1]]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n-1){
                return i;
            }
        }


        return -1;
    }
}
