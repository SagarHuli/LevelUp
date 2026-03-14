package DP.Knapsack.Unbounded;

public class PerfectSquares {

    /*
    https://leetcode.com/problems/perfect-squares/description/
     */
    public int numSquares(int n) {
        int [][] dp = new int[101][n+1];
        int [] arr = new int[100];
        for(int i=1; i<=100;i++) {
            arr[i-1] = i*i;
        }
        for(int i=0; i<=100; i++) dp[i][0] = 0;
        for(int j=0; j<=n; j++) dp[0][j] = n+1;

        for(int i=1; i<=100; i++) {
            int num = arr[i-1];
            for(int j=1; j<=n; j++) {
                if(j >= num) {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-(num)]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[100][n];
    }

    ///  1d array space optimised

    public int numSquaresV2(int n) {
        int [] dp = new int[n+1];
        int [] arr = new int[100];
        for(int i=1; i<=100;i++) {
            arr[i-1] = i*i;
        }

        for(int j=0; j<=n; j++) dp[j] = n+1;
        dp[0] = 0;
        for(int i=1; i<=100; i++) {
            int num = arr[i-1];
            for(int j=1; j<=n; j++) {
                if(j >= num) {
                    dp[j] = Math.min(dp[j], 1 + dp[j-(num)]);
                }
            }
        }
        return dp[n];
    }
}
