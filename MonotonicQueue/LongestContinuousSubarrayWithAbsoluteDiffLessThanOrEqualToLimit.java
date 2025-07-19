package MonotonicQueue;

import java.util.Deque;
import java.util.LinkedList;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    /**
     https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/submissions/1703222787/
     */
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> increasing = new LinkedList<>();
        Deque<Integer> decreasing = new LinkedList<>();
        int left = 0;
        int max = 0;
        for(int i=0;i<nums.length;i++) {
            int num = nums[i];
            while(!increasing.isEmpty() && num < increasing.peekLast()) {
                increasing.pollLast();
            }
            increasing.offerLast(num);

            while(!decreasing.isEmpty() && num > decreasing.peekLast()) {
                decreasing.pollLast();
            }
            decreasing.offerLast(num);

            while(decreasing.peekFirst() - increasing.peekFirst() > limit) {
                if(nums[left] == decreasing.peekFirst())
                    decreasing.pollFirst();
                if(nums[left] == increasing.peekFirst())
                    increasing.pollFirst();
                left++;
            }
            max = Math.max(max, i-left+1);
        }
        return max;
    }
}
