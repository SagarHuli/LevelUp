package DP.Knapsack.Unbounded;

import java.util.LinkedList;
import java.util.Queue;

public class CoinChange {

    /*
   https://leetcode.com/problems/coin-change/description/
     */
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[amount+1];
        queue.offer(0);
        visited[0] = true;
        int steps = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int curr = queue.poll();
                if(curr == amount) return steps;
                for(int cn : coins) {
                    long nextSum = (long)cn + curr;
                    if(nextSum <= amount && !visited[(int)nextSum]) {
                        visited[(int)nextSum] = true;
                        queue.offer((int)nextSum);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    // 2D DP tabulation
    public int coinChangeV2(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int i=0; i<=n; i++) dp[i][0] = 0;
        for(int j=0; j<=amount;j++) dp[0][j] = amount+1;

        for(int i=1; i<=n; i++) {
            int coinValue = coins[i-1];
            for(int j=1; j<=amount; j++) {
                if(coinValue <= j) {
                    // Take or not take
                    dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j-coinValue]);
                } else {
                    // Not take
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount] > amount ? -1 : dp[n][amount];
    }

    ///  1D space optimised
    public int coinChangeV3(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];

        for(int i=0; i<=n; i++) dp[0] = 0;
        for(int j=1; j<=amount;j++) dp[j] = amount+1;

        for(int i=1; i<=n; i++) {
            int coinValue = coins[i-1];
            for(int j=1; j<=amount; j++) {
                if(coinValue <= j) {
                    // Take or not take
                    dp[j] = Math.min(dp[j], 1+ dp[j-coinValue]);
                } else {
                    // Not take
                    // dp[j] = dp[j];
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
