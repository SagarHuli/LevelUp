package DP._2D_DP;

public class UniquePathsII {

    /*
    https://leetcode.com/problems/unique-paths-ii/description/
     */

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0; j<n; j++) {
                if(i>=0 && j>=0 && obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else if(i==0 && j==0) dp[i][j] = 1;
                else {
                    int up = 0, left = 0;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m-1][n-1];
    }

    public int uniquePathsWithObstaclesV2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        for(int i=0;i<m;i++) {
            for(int j=0; j<n; j++) {
                if(i>=0 && j>=0 && obstacleGrid[i][j] == 1) dp[j] = 0;
                else if(i==0 && j==0) dp[j] = 1;
                else {
                    if(j>0)
                        dp[j] += dp[j-1];
                }
            }
        }

        return dp[n-1];
    }
}
