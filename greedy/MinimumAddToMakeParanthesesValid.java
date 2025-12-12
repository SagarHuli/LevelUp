package greedy;

import java.util.Stack;

public class MinimumAddToMakeParanthesesValid {

    /*

     */
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(!st.isEmpty()) {
                if(st.peek() == '(' && ch == ')') {
                    st.pop();
                }
                else st.push(ch);
            } else {
                st.push(ch);
            }
        }
        return st.size();
    }

    // Greedy
    public int minAddToMakeValidV2(String s) {
        int open = 0, close = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                open++;
            } else {
                if(open > 0) {
                    open--;
                }else {
                    close++;
                }
            }
        }
        return open+close;
    }
}
