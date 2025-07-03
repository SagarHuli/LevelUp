package KadaneAlgorithm;

public class MaximumProductSubarray {
    /**
     https://leetcode.com/problems/maximum-product-subarray
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++) {
            int curr = nums[i];
            int temp = minSoFar;
            minSoFar = Math.min(curr, Math.min(minSoFar*curr, maxSoFar*curr));
            maxSoFar = Math.max(curr, Math.max(temp*curr, maxSoFar*curr));
            max = Math.max(max, maxSoFar);
        }
        return max;
    }
}
