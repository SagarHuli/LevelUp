package Stack;

import java.util.Stack;

public class RemoveDuplicateLetters {
    /**
     * https://leetcode.com/problems/remove-duplicate-letters/submissions/1694018218/
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        int [] lastIndex = new int[26];
        int [] seen = new int[26];
        for(int i=0;i<s.length();i++) {
            lastIndex[s.charAt(i)-'a'] = i;
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            Character c = s.charAt(i);
            if(seen[c-'a']==1)
                continue;
            while(!stack.isEmpty() && stack.peek() > c && i<lastIndex[stack.peek()-'a']) {
                seen[stack.peek()-'a']=0;
                stack.pop();
            }
            stack.push(c);
            seen[c-'a']=1;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
