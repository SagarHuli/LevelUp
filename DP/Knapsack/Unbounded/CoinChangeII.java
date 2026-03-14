package DP.Knapsack.Unbounded;

public class CoinChangeII {

    /*
    https://leetcode.com/problems/coin-change-ii
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int [][] dp = new int[n+1][amount+1];

        for(int i=0; i<=n;i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=amount; j++) {
                if(coins[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }

    ///  Space optimised

    public int changeV2(int amount, int[] coins) {
        int n = coins.length;
        int [] dp = new int[amount+1];
        dp[0] = 1;

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=amount; j++) {
                if(coins[i-1] <= j) {
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }
            }
        }
        return dp[amount];
    }
}
