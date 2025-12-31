package DP.StringDP;

public class LongestPalindromicSubsequence {

    /*
    https://leetcode.com/problems/longest-palindromic-subsequence/submissions/1870082264/
     */
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String reversed = sb.toString();
        return lcs(s, reversed);
    }

    private static int lcs(String s1, String s2) {
        int n = s1.length();
        int [] dp = new int[n+1];

        for(int i=1; i<=n; i++) {
            int prev = 0;
            for(int j=1; j<=n; j++) {
                int temp = dp[j];
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j-1]);
                }
                prev = temp;
            }
        }
        return dp[n];
    }


    public int longestPalindromeSubseqV2(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String reversed = sb.toString();
        return lcsV2(s, reversed);
    }

    private static int lcsV2(String s1, String s2) {
        int n = s1.length();
        int [] dp = new int[n+1];

        for(int i=1; i<=n; i++) {
            int prev = 0;
            for(int j=1; j<=n; j++) {
                int temp = dp[j];
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j-1]);
                }
                prev = temp;
            }
        }
        return dp[n];
    }
}
