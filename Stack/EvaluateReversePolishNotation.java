package Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    /**
     https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/1694996381/
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens) {
            if(isNumeric(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                int var2 = stack.pop();
                int var1 = stack.pop();
                int ans = 0;
                switch(s) {
                    case "*":
                        ans = var1*var2;
                        break;
                    case "+":
                        ans = var1+var2;
                        break;
                    case "/":
                        ans = var1/var2;
                        break;
                    default :
                        ans = var1-var2;
                }
                stack.push(ans);
            }
        }
        return stack.peek();
    }

    public boolean isNumeric(String s){
        try{
            Integer i = Integer.parseInt(s);
        } catch(Exception e) {
            return false;
        }
        return true;
    }
}
