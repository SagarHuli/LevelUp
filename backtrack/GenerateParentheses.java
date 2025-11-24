package backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    /*
    https://leetcode.com/problems/generate-parentheses/description/
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        tryCombination(list, n,n,"");
        return list;
    }

    private void tryCombination(List<String> list, int openRemaining, int closeRemaining, String str) {
        if(openRemaining ==0 && closeRemaining == 0) {
            list.add(str);
        }

        if(openRemaining > 0) {
            tryCombination(list, openRemaining-1, closeRemaining, str + "(");
        }
        if(closeRemaining > 0 && closeRemaining > openRemaining) {
            tryCombination(list, openRemaining, closeRemaining-1, str + ")");
        }

    }

    // backtrack

    public List<String> generateParenthesisV2(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder sb, int open,
                                  int close, int max) {
        if(sb.length() == max*2) result.add(sb.toString());

        else {
            if(open < max) {
                sb.append("(");
                backtrack(result, sb, open+1, close, max);
                sb.deleteCharAt(sb.length()-1);
            }
            if(close < open) {
                sb.append(")");
                backtrack(result, sb, open, close+1, max);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
