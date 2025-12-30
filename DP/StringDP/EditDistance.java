package DP.StringDP;

public class EditDistance {

    /*
    https://leetcode.com/problems/edit-distance/description/
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int [][] dp = new int[m+1][n+1];
        for(int j=0; j<=n; j++) dp[0][j] = j;
        for(int i=0; i<=m; i++) dp[i][0] = i;

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j],
                            Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }

        return dp[m][n];
    }


    public int minDistanceV2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int [] cur = new int[n+1];
        int [] prev = new int[n+1];
        for(int j=0; j<=n; j++) prev[j] = j;

        for(int i=1; i<=m; i++) {
            cur[0] = i;
            for(int j=1; j<=n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    cur[j] = prev[j-1];
                } else {
                    cur[j] = 1 + Math.min(prev[j],
                            Math.min(cur[j-1], prev[j-1]));
                }
            }
            prev = cur.clone();
        }
        return prev[n];
    }
}
