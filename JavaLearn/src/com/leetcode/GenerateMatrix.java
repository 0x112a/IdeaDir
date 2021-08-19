package com.leetcode;

public class GenerateMatrix {
    /**
     * 	ans := make([][]int,n)
     * 	for i,_ := range ans{
     * 		ans[i]= make([]int,n)
     *        }
     * 	nn := n*n
     * 	var c,r int
     * 	var directionIndex int
     *
     * 	for i:=1;i<=nn;i++{
     * 		ans[r][c] = i
     *
     * 		nextRow ,nextColunm := r + directions[directionIndex].x,c + directions[directionIndex].y
     *
     * 		if nextRow < 0 || nextRow>=n || nextColunm<0 || nextColunm>=n || ans[nextRow][nextColunm] != 0 {
     * 			directionIndex = (directionIndex+1)%4
     *        }
     *
     * 		r +=directions[directionIndex].x
     * 		c += directions[directionIndex].y
     *
     *    }
     * 	return ans
     *
     *
     */
    public int[][] generateMatrix(int n) {

        int[][] ints = new int[n][n];
        int sum = n * n;
        int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row=0;
        int column=0;
        int directIndex = 0;

        for (int i = 1; i<= sum ;i++){
            ints[row][column] = i;

            int nextRow = row+direct[directIndex][0];
            int nextColumn = column + direct[directIndex][1];

            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || ints[nextRow][nextColumn] != 0){
                directIndex = (directIndex+1)%4;
            }

            row = row+direct[directIndex][0];
            column = column + direct[directIndex][1];
        }

        return ints;
    }
}
