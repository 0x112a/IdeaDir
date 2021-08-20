package com.leetcode;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length-1;
        int n = matrix[0].length;
        int c = 0;

        while (c < n && m >= 0 ){
            if (matrix[m][c] < target){
                c++;
            }else if(matrix[m][c] > target){
                m--;
            }else {
                return true;
            }
        }

        return false;
    }
}
