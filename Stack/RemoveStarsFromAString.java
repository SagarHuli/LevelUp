package Stack;

import java.util.Stack;

public class RemoveStarsFromAString {
    /**
     https://leetcode.com/problems/removing-stars-from-a-string/submissions/1694970944/
     */
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='*') {
                if(!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
