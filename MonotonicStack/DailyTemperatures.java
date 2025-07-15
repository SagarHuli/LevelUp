package MonotonicStack;

import java.util.Stack;

public class DailyTemperatures {
    /**
     https://leetcode.com/problems/daily-temperatures/submissions/1699044739/
     */

    static class Pair {
        int num;
        int index;
        public Pair(int a, int b) {
            num = a;
            index = b;
        }
    }
    public int[] dailyTemperatures(int[] temp) {
        int [] res = new int[temp.length];
        Stack<Pair> stack = new Stack<>();
        for(int i=0;i<temp.length;i++) {
            while(!stack.isEmpty() && temp[i] > stack.peek().num) {
                Pair val = stack.pop();
                res[val.index] = i-val.index;
            }
            stack.push(new Pair(temp[i], i));
        }
        return res;
    }
}
