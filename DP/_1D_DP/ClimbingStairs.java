package DP._1D_DP;

public class ClimbingStairs {

    /*
    https://leetcode.com/problems/climbing-stairs/description/
     */
    public int climbStairs(int n) {
        int [] dp = new int[n+1];
        dp[n] = 1;
        dp[n-1] = 1;
        for(int i=n-2; i>=0; i--) {
            dp[i] = dp[i+1] + dp[i+2];
        }
        return dp[0];
    }

    public int climbStairsV2(int n) {
        int oneStep = 1;
        int twoStep = 1;
        for(int i=2; i<=n; i++) {
            int temp = oneStep;
            oneStep = oneStep + twoStep;
            twoStep = temp;
        }
        return oneStep;
    }
}
