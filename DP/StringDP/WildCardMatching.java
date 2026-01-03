package DP.StringDP;

public class WildCardMatching {

    /*
    https://leetcode.com/problems/wildcard-matching/submissions/1872799613/
     */
    // Recursive with memoization
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        Boolean [][]dp = new Boolean[m+1][n+1];
        return recurse(s,p,m-1,n-1, dp);
    }

    private boolean recurse(String s, String p, int i, int j, Boolean[][] dp) {
        if(i<0 && j<0) return true;
        if(j<0 && i>=0) return false;
        if(i<0 && j>=0) {
            for(int k=0; k<=j;k++) {
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }

        if(dp[i][j] != null) return dp[i][j];

        boolean match = false;
        if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
            match = recurse(s,p,i-1,j-1, dp);
        }
        if(p.charAt(j) == '*') {
            match = recurse(s,p,i-1,j, dp) | recurse(s,p,i,j-1, dp);
        }
        return dp[i][j] = match;
    }

    // DP with memoization

    public boolean isMatchV2(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int j=1; j<=n;j++) {
            if(p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            }
        }

        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }

        return dp[m][n];

    }
}
