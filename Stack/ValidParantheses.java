package Stack;

import java.util.Stack;

public class ValidParantheses {
    /**
     * https://leetcode.com/problems/valid-parentheses/submissions/1693873632/
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            Character c = s.charAt(i);
            if(c==']') {
                if(!stack.isEmpty() && stack.peek()=='['){
                    stack.pop();
                } else {
                    return false;
                }
            } else if(!stack.isEmpty() && c=='}') {
                if(stack.peek()=='{'){
                    stack.pop();
                } else {
                    return false;
                }
            } else if(!stack.isEmpty() && c==')') {
                if(stack.peek()=='('){
                    stack.pop();
                } else {
                    return false;
                }
            } else stack.push(c);
        }
        return stack.isEmpty();
    }
}
