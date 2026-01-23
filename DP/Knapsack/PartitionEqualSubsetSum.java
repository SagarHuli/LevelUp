package DP.Knapsack;

public class PartitionEqualSubsetSum {

    // recursive : TLE  TC : 2powN
     public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i:nums) sum += i;
        if(sum % 2 != 0) return false;
        return calculate(nums, nums.length-1, sum/2);
    }

    private boolean calculate(int[] nums, int ind, int target) {
        if(target == 0) return true;
        if(ind == 0) return nums[0] == target;
        boolean take = false;
        if(target >= nums[ind]) {
            take = calculate(nums, ind-1, target - nums[ind]);
        }
        boolean notTake = calculate(nums, ind-1, target);
        return take | notTake;
    }

    // DP tabulation
    public boolean canPartitionV2(int[] nums) {
        int sum = 0;
        for(int i:nums) sum += i;
        if(sum % 2 != 0) return false;
        int n = nums.length;
        int k = sum/2;
        boolean [][] dp = new boolean[n][k+1];
        for(int i=0; i<n; i++) dp[i][0] = true;
        if(nums[0] == k) dp[0][nums[0]] = true;

        for(int ind=1; ind<n; ind++) {
            for(int target=0; target<=k; target++) {
                boolean take = false;
                if(target >= nums[ind]) {
                    take = dp[ind-1][target - nums[ind]];
                }
                boolean notTake = dp[ind-1][target];
                dp[ind][target] = take | notTake;
            }
        }
        return dp[n-1][k];
    }

    // Space optimized to 2 arrays of length target

    public boolean canPartitionV3(int[] nums) {
        int sum = 0;
        for(int i:nums) sum += i;
        if(sum % 2 != 0) return false;
        int n = nums.length;
        int k = sum/2;
        boolean [] prev = new boolean[k+1];
        boolean [] cur = new boolean[k+1];
        prev[0] = true;

        for(int ind=1; ind<n; ind++) {
            for(int target=k; target>=0; target--) {
                boolean take = false;
                if(target >= nums[ind]) {
                    take = prev[target - nums[ind]];
                }
                boolean notTake = prev[target];
                cur[target] = take | notTake;
            }
            prev = cur;
        }
        return prev[k];
    }

    // Space optimized to 1 array of length target
    public boolean canPartitionV4(int[] nums) {
        int sum = 0;
        for(int i:nums) sum += i;
        if(sum % 2 != 0) return false;
        int n = nums.length;
        int k = sum/2;
        boolean [] prev = new boolean[k+1];
        prev[0] = true;

        for(int ind=1; ind<n; ind++) {
            for(int target=k; target>=0; target--) {
                boolean take = false;
                if(target >= nums[ind]) {
                    take = prev[target - nums[ind]];
                }
                boolean notTake = prev[target];
                prev[target] = take | notTake;
            }
        }
        return prev[k];
    }
}
