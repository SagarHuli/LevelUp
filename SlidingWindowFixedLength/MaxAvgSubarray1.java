package SlidingWindowFixedLength;

public class MaxAvgSubarray1 {
    /**
     https://leetcode.com/problems/maximum-average-subarray-i
     */
    public double findMaxAverage(int[] nums, int k) {
        double avg = 0.0;
        double sum=0;
        for(int i=0;i<k;i++) {
            sum += nums[i];
        }
        avg = sum/k;
        double currAvg;
        for(int i=k;i<nums.length;i++) {
            sum = sum + nums[i] - nums[i-k];
            currAvg = sum/k;
            avg = Math.max(currAvg, avg);
        }
        return avg;
    }
}
