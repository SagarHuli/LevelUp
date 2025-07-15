package Stack;

public class LongestValidParantheses {
    /**
     https://leetcode.com/problems/longest-valid-parentheses/submissions/1698150725/
     */
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, max = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(')
                left++;
            else right++;
            if(left==right)
                max = Math.max(max, left*2);
            if(right>left) {
                left=0;
                right=0;
            }
        }

        left=0;
        right=0;
        for(int i=s.length()-1;i>=0;i--) {
            if(s.charAt(i)=='(')
                left++;
            else right++;
            if(left==right)
                max = Math.max(max, left*2);
            if(left>right) {
                left=0;
                right=0;
            }
        }
        return max;
    }
}
