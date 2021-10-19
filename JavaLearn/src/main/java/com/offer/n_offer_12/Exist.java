package com.offer.n_offer_12;

public class Exist {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int row = board.length;
        int column = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (dfs(board,chars,i,j,0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] chars, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != chars[k]) return false;
        if (k == chars.length-1) return true;
        //标记此处已读过
        board[i][j] = '\0';

        boolean flag = dfs(board,chars,i+1,j,k+1) || dfs(board,chars,i-1,j,k+1)
                || dfs(board,chars,i,j+1,k+1) || dfs(board,chars,i,j-1,k+1);

        //恢复被修改过的char
        board[i][j] = chars[k];
        return flag;
    }
}
