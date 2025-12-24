package DP._2D_DP;

import java.util.List;

public class Triangle {

    /*
    https://leetcode.com/problems/triangle/description/
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int total = 0;
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[] dp = new int[n];

        for(int j=0;j<n;j++) {
            dp[j] = triangle.get(m-1).get(j);
        }

        for(int i=m-2; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
