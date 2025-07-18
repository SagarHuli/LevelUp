package MonotonicStack;

import java.util.Stack;

public class NumberOfVisiblePeopleInAQueue {

    /**
     https://leetcode.com/problems/number-of-visible-people-in-a-queue/submissions/1701901901/
     */
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int [] ret = new int[heights.length];

        for(int i=heights.length-1;i>=0;i--) {
            int cur = 0;
            while(!stack.isEmpty() && heights[i]>stack.peek()) {
                stack.pop();
                cur++;
            }
            if(!stack.isEmpty())
                cur++;
            ret[i] = cur;
            stack.push(heights[i]);
        }
        return ret;
    }
}
