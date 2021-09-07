package com.leetcode;

public class Rotate {
    /**
     * 	//水平反转
     * 	n := len(matrix)
     * 	for i:= 0;i<n/2;i++{
     * 		for j :=0 ; j<n;j++{
     * 			matrix[i][j],matrix[n-i-1][j] = matrix[n-i-1][j] ,matrix[i][j]
     *                }* 	}
     *
     * 	//主对角线反转
     * 	for i:= 0;i<n;i++{
     * 		for j :=0 ; j<i;j++{
     * 			matrix[i][j],matrix[j][i] = matrix[j][i] ,matrix[i][j]
     * 		}
     * 	}
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;

        for (int i = 0 ; i < len/2; i++){
            for (int j = 0; j < len; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - i -1][j];
                matrix[len-i-1][j] = temp;
            }
        }

        for (int i = 0; i<len ; i++){
            //位于对角线上的元素可以不用交换，也可以交换
            for (int j = 0 ; j <= i; j++ ){
//          for (int j = 0 ; j <= i; j++ ){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
