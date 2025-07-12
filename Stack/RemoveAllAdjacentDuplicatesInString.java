package Stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    /**
     * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!stack.isEmpty()) {
                if(stack.peek() == c) {
                    stack.pop();
                } else stack.push(c);
            } else stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
