package Stack;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<String> string = new Stack<>();
        String currString = "";
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int currNum = 0;
                while(Character.isDigit(s.charAt(i))) {
                    currNum = (currNum * 10) + (s.charAt(i) - '0');
                    i++;
                }
                num.push(currNum);
            } else if (s.charAt(i) - 'a' >= 0 && s.charAt(i) - 'a' <= 26) {
                currString+=s.charAt(i);
                i++;
            } else if (s.charAt(i) == '[') {
                string.push(currString);
                currString = "";
                i++;
            } else {
                int poppedNum = num.pop();
                StringBuilder sb = new StringBuilder(string.pop());
                while (poppedNum > 0) {
                    sb.append(currString);
                    poppedNum--;
                }
                currString = sb.toString();
                i++;
            }
        }
        return currString;
    }
}
