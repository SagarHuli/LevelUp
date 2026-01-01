package DP.StringDP;

import java.util.List;

public class WordBreak {

    /*
    https://leetcode.com/problems/word-break/submissions/1871016511/
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        int len = s.length();
        boolean []dp = new boolean[len+1];
        dp[len] = true;

        for(int i=len-1;i>=0; i--) {
            for(String word : wordDict) {
                int wordLength = word.length();
                if(i + wordLength <= len &&
                        word.equals(s.substring(i, i+wordLength))) {
                    dp[i] = dp[i + wordLength];
                }
                if(dp[i]) break;
            }
        }
        return dp[0];
    }
}
