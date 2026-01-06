package DP.StringDP;

import java.util.Arrays;

public class DistinctSubsequences {

    /*
    https://leetcode.com/problems/distinct-subsequences/
     */
    public int numDistinct(String s, String t) {
        int [][] dp = new int[s.length()+1][t.length()+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return recurse(s,t,0,0,dp);
    }

    private int recurse(String s, String t, int i, int j, int [][]dp) {
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)) {
            dp[i][j] = recurse(s,t,i+1,j+1,dp) + recurse(s,t,i+1,j,dp);
        }
        else {
            dp[i][j] = recurse(s,t,i+1,j,dp);
        }
        return dp[i][j];
    }

    // DP tabulation

    public int numDistinctV2(String s, String t) {
        int m = s.length(), n = t.length();
        int [][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++) dp[i][n] = 1;

        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                } else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
}
