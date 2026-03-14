package DP.Knapsack.Unbounded;

public class IntegerBreak {

    /*
    https://leetcode.com/problems/integer-break/
     */
    public int integerBreak(int n) {
        if(n/2 < 2) return (n+1)/2;
        int m = (n+1)/2;
        int [][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++) dp[i][0] = 0;
        for(int j=0; j<=n; j++) dp[0][j] = j;

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(j > i-1) {
                    dp[i][j] = Math.max(dp[i-1][j], i*dp[i][j-i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }

    ///  Space optimized
    public int integerBreakV2(int n) {
        if(n/2 < 2) return (n+1)/2;
        int m = (n+1)/2;
        int [] dp = new int[n+1];

        for(int j=0; j<=n; j++) dp[j] = j;

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(j > i-1) {
                    dp[j] = Math.max(dp[j], i*dp[j-i]);
                }
            }
        }
        return dp[n];
    }
}
