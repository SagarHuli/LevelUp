package DP._2D_DP;

public class BurstBalloons {
    /*
    https://leetcode.com/problems/burst-balloons/submissions/1865661110/
     */
    public int maxCoins(int[] nums) {
        int [] arr = new int[nums.length+2];
        arr[0] = arr[arr.length-1] = 1;
        for(int i=0; i<nums.length; i++) {
            arr[i+1] = nums[i];
        }
        int [][]dp = new int[arr.length][arr.length];
        return burst(dp, arr, 0, arr.length-1);
    }

    private static int burst(int[][] dp, int[] nums, int left, int right) {
        if(left+1 == right) return 0;
        if(dp[left][right] > 0) return dp[left][right];

        int maxCoins = 0;
        for(int i = left+1; i<right; i++) {
            maxCoins = Math.max(maxCoins, nums[left] * nums[i]* nums[right]
                    + burst(dp, nums, left, i) + burst(dp, nums, i, right));
        }
        dp[left][right] = maxCoins;
        return maxCoins;
    }
}
