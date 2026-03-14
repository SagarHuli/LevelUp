package DP.Knapsack;

public class CountOfSubsetWithSumEqualToK {

    /*
    https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
     */
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        int [][] dp= new int [n+1][target+1];
        for(int i=0;i<=n;i++)
            dp[i][0] = 1;
        for(int i=1; i<=n; i++) {
            for(int j=0; j<=target; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= nums[i-1]) {
                    dp[i][j] += dp[i-1][j- nums[i-1]];
                }
            }
        }
        return dp[n][target];
    }

    ///  1d array space optimised
    public int perfectSumV2(int[] nums, int target) {
        // code here
        int n = nums.length;
        int [] prev = new int [target+1];
        int [] curr = new int [target+1];
        prev[0]=1;
        for(int i=1; i<=n; i++) {
            for(int j=0; j<=target; j++) {
                curr[j] = prev[j];
                if(j >= nums[i-1]) {
                    curr[j] += prev[j- nums[i-1]];
                }
            }
            System.arraycopy(curr, 0, prev, 0, target+1);
        }
        return prev[target];
    }
}
