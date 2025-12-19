package DP._1D_DP;

public class MinCostClimbingStairs {
    /*
    https://leetcode.com/problems/min-cost-climbing-stairs/submissions/1859376777/
     */
    public int minCostClimbingStairs(int[] cost) {
        int [] dp = new int[cost.length];
        dp[cost.length-1] = cost[cost.length-1];
        dp[cost.length-2] = cost[cost.length-2];
        for(int i = cost.length-3; i>=0;i--) {
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }
        return Math.min(dp[0],dp[1]);
    }

    public int minCostClimbingStairsV2(int[] cost) {
        int first = cost[0];
        int second = cost[1];

        for (int i = 2; i < cost.length; i++) {
            // Calculate the new minimum cost using the last two values
            int current = cost[i] + Math.min(first, second);
            first = second;
            second = current;
        }
        // Cost to get past the last two steps
        return Math.min(first, second);
    }
}
