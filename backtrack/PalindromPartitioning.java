package backtrack;

import java.util.ArrayList;
import java.util.List;

public class PalindromPartitioning {
    /*
    https://leetcode.com/problems/palindrome-partitioning/submissions/1843337086/
     */
    // Backtracking + 2D DP
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++) {
            for(int j=i; j<s.length();j++) {
                dp[i][j] = isPalindrome(s, i, j);
            }
        }
        backtrack(result, new ArrayList<>(), 0, s, dp);
        return result;
    }

    private static void backtrack(List<List<String>> result, List<String> current,
                                  int start, String str, boolean[][] dp) {
        if(start == str.length()) {
            result.add(new ArrayList<>(current));
        }
        for(int end=start; end < str.length(); end++) {
            if(dp[start][end]) {
                current.add(str.substring(start, end+1));
                backtrack(result, current, end+1, str, dp);
                current.remove(current.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String str, int start, int end) {
        while(start < end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }



    /////////////

    // Backtracking
    public List<List<String>> partitionV2(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 0, s);
        return result;
    }

    private static void backtrack(List<List<String>> result, List<String> current,
                                  int start, String str) {
        if(start == str.length()) {
            result.add(new ArrayList<>(current));
        }
        for(int end=start; end < str.length(); end++) {
            if(isPalindrome(str, start, end)) {
                current.add(str.substring(start, end+1));
                backtrack(result, current, end+1, str);
                current.remove(current.size()-1);
            }
        }
    }
}
