package KadaneAlgorithm;

public class MaximumSumCircularSubarry {
    public int maxSubarraySumCircular(int[] nums) {
        /**
         https://leetcode.com/problems/maximum-sum-circular-subarray/
         */
        int currMax = 0;
        int max = Integer.MIN_VALUE;
        int currMin = 0;
        int min = Integer.MAX_VALUE;
        int total = 0;
        for(int i=0;i<nums.length;i++) {
            total+= nums[i];
            currMax = Math.max(nums[i], currMax+nums[i]);
            max = Math.max(max, currMax);
            currMin = Math.min(nums[i], currMin+nums[i]);
            min = Math.min(min, currMin);
        }
        if(max<0) {
            return max;
        }
        return Math.max(max, total-min);
    }
}
