package com.offer.n_offer_29;

public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        if ( row == 0 || column == 0) {
            return null;
        }
        //judege matrix is empty

        int len = column * row;
        int[] ans = new int[len];
        boolean[][] visited = new boolean[row][column];
        int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int direct = 0;

        int r = 0, c = 0;

        for (int i = 0; i < len; i++) {
            ans[i] = matrix[r][c];
            visited[r][c] = true;
            int nextRow = r + direction[direct][0],nextColumn = c + direction[direct][1];
            if (nextRow < 0 || nextRow >= row || nextColumn < 0
                    || nextColumn >= column || visited[nextRow][nextColumn] ){

                direct = (direct + 1)%4;
            }
            r += direction[direct][0];
            c += direction[direct][1];
        }

        return ans;
    }

}
