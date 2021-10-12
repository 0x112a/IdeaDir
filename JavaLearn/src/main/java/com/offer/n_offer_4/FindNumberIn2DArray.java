package com.offer.n_offer_4;

public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix,int target){

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;



        int i = 0,j = m-1;
        while (i < n && j >= 0){
            int temp = matrix[i][j];
            if (temp == target){
                return true;
            }else if (temp < target){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }
}
