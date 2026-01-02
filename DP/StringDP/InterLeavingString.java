package DP.StringDP;

public class InterLeavingString {

    /*
    https://leetcode.com/problems/interleaving-string/description/
     */

    // Recursive with memoization
    public boolean isInterleave(String s1, String s2, String s3) {
        int [][] dp = new int[s1.length()+1][s2.length()+1];
        return recurse(s1, s2, s3, 0,0,0, dp);
    }

    private static boolean recurse(String s1, String s2, String s3,
                                   int i, int j, int k, int[][] dp) {
        if(i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }
        if(k == s3.length()) return false;

        if(dp[i][j] != 0) {
            return dp[i][j] == 1;
        }
        boolean isInterLeave = false;
        if( i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            isInterLeave =  recurse(s1,s2,s3, i+1, j, k+1, dp);
        }
        if(!isInterLeave && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            isInterLeave = recurse(s1,s2,s3, i, j+1, k+1, dp);
        }
        dp[i][j] = isInterLeave ? 1 : 2;
        return isInterLeave;
    }

    //Iterative DP

    public boolean isInterleaveV2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean [][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for(int i=0; i<=s1.length(); i++) {
            for(int j=0; j<=s2.length(); j++) {
                if(i>0 && s1.charAt(i-1) == s3.charAt(i+j-1)) {
                    dp[i][j] = dp[i-1][j];
                }
                if(j >0 && s2.charAt(j-1) == s3.charAt(i+j-1)) {
                    dp[i][j] |= dp[i][j-1];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
