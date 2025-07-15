package MonotonicStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        /**
         https://leetcode.com/problems/next-greater-element-i/description/
         */
        Map<Integer, Integer> nums1Index = new HashMap<>();
        int res [] = new int[nums1.length];
        for(int i=0;i<nums1.length;i++) {
            nums1Index.put(nums1[i],i);
            res[i]= -1;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<nums2.length;i++) {
            int cur = nums2[i];
            while(!stack.isEmpty() && cur > stack.peek()) {
                int val = stack.pop();
                res[nums1Index.get(val)] = cur;
            }
            if(nums1Index.containsKey(cur)) {
                stack.push(cur);
            }
        }
        return res;
    }
}
