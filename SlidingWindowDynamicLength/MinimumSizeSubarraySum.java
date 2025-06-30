package SlidingWindowDynamicLength;

public class MinimumSizeSubarraySum {
    /*
    https://leetcode.com/problems/minimum-size-subarray-sum
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int i=0,j=0;
        int sum = 0;
        int n = nums.length;
        while(i<n && j<n) {
            sum+= nums[j];
            if(sum >= target) {
                while(sum-nums[i] >= target) {
                    sum -= nums[i];
                    i++;
                    minLen = Math.min(minLen, j-i+1);
                }
                minLen = Math.min(minLen, j-i+1);
                j++;
            } else {
                j++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0: minLen;
    }

    */
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int i=0,j=0;
        int sum = 0;
        int n = nums.length;
        while(j<n) {
            sum+= nums[j];
            while(sum >= target) {
                minLen = Math.min(minLen, j-i+1);
                sum -= nums[i++];
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE ? 0: minLen;
    }
}
