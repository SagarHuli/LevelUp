package SlidingWindowDynamicLength;

public class MaxConsecutiveOnesIII {
    /**
     https://leetcode.com/problems/max-consecutive-ones-iii/
     */
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int i=0, j=0, n = nums.length;
        int ones = 0;
        while(j<n) {
            if(nums[j]==1) {
                ones++;
            }
            if(j-i+1 -ones > k) {
                max = Math.max(max, j-i);
                if(nums[i]==1)
                    ones--;
                i++;
            }
            else j++;
        }
        return Math.max(max, j-i);
    }
}
