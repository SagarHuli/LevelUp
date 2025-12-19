package DP._1D_DP;

public class HouseRobber {

    /*
    https://leetcode.com/problems/house-robber/
     */
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length+1];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i=2; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }

    public int robV2(int[] nums) {
        if(nums.length == 1) return nums[0];

        int first =0;
        int second = 0;
        for(int i=0; i<nums.length; i++) {
            int temp = first;
            first = Math.max(second + nums[i], first);
            second = temp;
        }
        return first;
    }
}
