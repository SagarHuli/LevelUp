package Stack;

import java.util.Stack;

public class BasicCalculatorII {
    /**
     https://leetcode.com/problems/basic-calculator-ii/submissions/1695091744/
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        int num = 0;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                num = num*10 + (ch-'0');
            }
            if((!Character.isDigit(ch) && ch!=' ') || (i==s.length()-1)) {
                if(op=='+') {
                    stack.push(num);
                } else if(op == '-') {
                    stack.push(-1*num);
                } else if(op == '*') {
                    stack.push(num * stack.pop());
                } else if(op=='/'){
                    stack.push(stack.pop()/num);
                }
                op = ch;
                num=0;
            }
        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum+= stack.pop();
        }
        return sum;
    }
}
