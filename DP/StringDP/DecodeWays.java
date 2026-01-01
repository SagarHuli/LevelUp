package DP.StringDP;

public class DecodeWays {

    /*
    https://leetcode.com/problems/decode-ways/
     */
    public int numDecodings(String s) {
        int n = s.length();
        int [] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        if(n == 1) return dp[1];

        for(int i=2; i<=n; i++) {
            if(s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
            }
            int num = Integer.parseInt(s.substring(i-2, i));
            if(s.charAt(i-2) != '0' && num <=26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
