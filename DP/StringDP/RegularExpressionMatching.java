package DP.StringDP;

public class RegularExpressionMatching {

    /*
    https://leetcode.com/problems/regular-expression-matching/description/
     */
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        return isMatch(s, p, s.length()-1, p.length()-1, dp);
    }

    private static boolean isMatch(String s, String p, int i,
                                   int j, Boolean[][]dp) {
        if(i<0 && j<0) return true;
        if(j<0 && i>=0) return false;
        if(dp[i+1][j+1] != null) return dp[i+1][j+1];
        if(i<0 && j>=0)  {
            if(p.charAt(j) == '*') return isMatch(s,p,i,j-2,dp);
            return false;
        }
        boolean match = false;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            match = isMatch(s,p,i-1,j-1,dp);
        } else if(p.charAt(j) == '*') {
            match|= isMatch(s,p,i,j-2,dp);
            if(s.charAt(i) == p.charAt(j - 1) ||
                    p.charAt(j - 1) == '.') {
                match|= isMatch(s, p, i - 1, j,dp);
            }
        }
        return dp[i+1][j+1] = match;
    }

    // DP table

    public boolean isMatchV2(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // Pre-fill for patterns like a*, a*b*, etc. matching empty string
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // Case 1: Match zero (skip "x*")
                    dp[i][j] = dp[i][j - 2];
                    // Case 2: Match one or more (if current char matches preceding char)
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
