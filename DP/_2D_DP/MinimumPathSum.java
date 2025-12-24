package DP._2D_DP;

public class MinimumPathSum {

    /*
    https://leetcode.com/problems/minimum-path-sum/description/
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 && j==0) dp[i][j] = grid[i][j];
                else {
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if(i>0) up = grid[i][j] + dp[i-1][j];
                    if(j>0) left = grid[i][j] + dp[i][j-1];
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[m-1][n-1];
    }


    public int minPathSumV2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 && j==0) dp[j] = grid[i][j];
                else {
                    int up = i>0 ? dp[j] : Integer.MAX_VALUE;
                    int left = j>0 ? dp[j-1] : Integer.MAX_VALUE;
                    dp[j] = grid[i][j] + Math.min(up, left);
                }
            }
        }
        return dp[n-1];
    }
}
