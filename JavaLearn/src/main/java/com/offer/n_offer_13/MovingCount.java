package com.offer.n_offer_13;

public class MovingCount {

    int m ,n , k;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited  = new boolean[m][n];


        return dfs(0,0,0,0);
    }
    public int dfs(int i, int j, int si, int sj){
        if (i >= m || j >= n || k < si + sj || visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        //sj-8 eg: 19 + 1 = 20 ,19 : 1+9 = 10 , 20: 2+0 = 2 ,10 - 8 =2;
        return 1 + dfs(i+1,j,(i+1)%10 != 0 ? si+1 : si - 8,sj) + dfs(i,j+1,si,(j+1)%10 != 0 ? sj+1 : sj-8);
    }



}
