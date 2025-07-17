package MonotonicStack;

import java.util.Stack;

public class _132Pattern {

    /**
     * https://leetcode.com/problems/132-pattern/submissions/1701400816/
     */
    public boolean find132pattern(int[] nums) {
        Stack<int []> stack = new Stack<>();
        int curMin = nums[0];
        for(int i =0;i<nums.length;i++) {
            while(!stack.isEmpty() && nums[i] >= stack.peek()[0]) {
                stack.pop();
            }
            if(!stack.isEmpty() && nums[i] > stack.peek()[1])
                return true;
            stack.push(new int[]{nums[i], curMin});
            curMin = Math.min(curMin, nums[i]);
        }
        return false;
    }
}
