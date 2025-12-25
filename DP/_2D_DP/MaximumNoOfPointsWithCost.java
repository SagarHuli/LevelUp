package DP._2D_DP;

public class MaximumNoOfPointsWithCost {

    /*
    https://leetcode.com/problems/maximum-number-of-points-with-cost/description/
     */
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long dp[] = new long[n];

        for(int j=0; j<n; j++) {
            dp[j] = points[0][j];
        }

        for(int i=1;i<m;i++) {
            long [] newDp = new long[n];

            long [] leftMax = new long[n];
            leftMax[0] = dp[0];
            for(int j=1; j<n; j++) {
                leftMax[j] = Math.max(leftMax[j-1]-1, dp[j]);
            }

            long [] rightMax = new long[n];
            rightMax[n-1] = dp[n-1];
            for(int j=n-2; j>=0; j--) {
                rightMax[j] = Math.max(rightMax[j+1]-1, dp[j]);
            }

            for(int j=0; j<n;j++) {
                newDp[j] = points[i][j] + Math.max(leftMax[j], rightMax[j]);
            }

            dp = newDp;
        }

        long maxVal = 0;
        for(long val: dp) {
            maxVal = Math.max(maxVal, val);
        }

        return maxVal;
    }
}
