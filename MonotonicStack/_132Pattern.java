package MonotonicStack;

import java.util.Stack;

public class _132Pattern {

    /**
     * https://leetcode.com/problems/132-pattern/submissions/1701400816/
     */
    public boolean find132pattern(int[] nums) {
        Stack<int []> stack = new Stack<>();
        int curMin = nums[0];
        for (int num : nums) {
            while (!stack.isEmpty() && num >= stack.peek()[0]) {
                stack.pop();
            }
            if (!stack.isEmpty() && num > stack.peek()[1])
                return true;
            stack.push(new int[]{num, curMin});
            curMin = Math.min(curMin, num);
        }
        return false;
    }
}
