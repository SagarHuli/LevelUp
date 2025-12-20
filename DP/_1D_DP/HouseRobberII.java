package DP._1D_DP;

public class HouseRobberII {

    /*
    https://leetcode.com/problems/house-robber-ii/description/
     */
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(robRange(nums, 0, nums.length-2), robRange(nums, 1, nums.length-1));
    }

    private static int robRange(int[] nums, int start, int end) {
        int prev = 0;
        int prev2 = 0;
        for(int i=start;i<=end;i++) {
            int temp = prev;
            prev = Math.max(prev2+nums[i], prev);
            prev2 =temp;
        }
        return prev;
    }
}
