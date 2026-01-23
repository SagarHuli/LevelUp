package DP.Knapsack;

public class _01Knapsack {

    /*
    https://www.naukri.com/code360/problems/0-1-knapsack_920542
     */
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        // return recurse(maxWeight, weight, value, n-1);

        int N = weight.length;
        int[][] dp = new int[weight.length+1][maxWeight+1];
        for(int i=weight[0]; i<= maxWeight; i++) {
            dp[0][i] = value[0];
        }

        for(int i=1; i<weight.length; i++) {
            for(int j=0; j<=maxWeight; j++) {
                int notTake = dp[i-1][j];
                int take = Integer.MIN_VALUE;
                if(weight[i] <= j) {
                    take = value[i] +dp[i-1][j-weight[i]];
                }
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[n-1][maxWeight];
    }

    static int recurse(int W, int [] weight, int []value, int index) {
        if(index ==0) {
            if(weight[index] <= W) return value[index];
            else return 0;
        }
        int take = value[index] + recurse(W-weight[index], weight, value, index-1);
        int notTake = 0 + recurse(W, weight, value, index-1);
        return Math.max(take, notTake);
    }

    // space optimized to 2 array
    static int knapsackV2(int[] weight, int[] value, int n, int maxWeight) {
        // return recurse(maxWeight, weight, value, n-1);

        int N = weight.length;
        int[] prev = new int[maxWeight+1];
        int [] cur = new int[maxWeight+1];
        for(int i=weight[0]; i<= maxWeight; i++) {
            prev[i] = value[0];
        }

        for(int i=1; i<weight.length; i++) {
            for(int j=0; j<=maxWeight; j++) {
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;
                if(weight[i] <= j) {
                    take = value[i] +prev[j-weight[i]];
                }
                cur[j] = Math.max(take, notTake);
            }
            prev = cur.clone();
        }
        return prev[maxWeight];
    }

    ///  Optimal : single array space
    static int knapsackV3(int[] weight, int[] value, int n, int maxWeight) {
        // return recurse(maxWeight, weight, value, n-1);

        int N = weight.length;
        int [] dp = new int[maxWeight+1];
        for(int i=weight[0]; i<= maxWeight; i++) {
            dp[i] = value[0];
        }

        for(int i=1; i<weight.length; i++) {
            // Traverse backwards to ensure we use values from the previous item only
            for (int j = maxWeight; j >= weight[i]; j--) {
                int notTake = dp[j];
                int take = Integer.MIN_VALUE;
                if(weight[i] <= j) {
                    take = value[i] +dp[j-weight[i]];
                }
                dp[j] = Math.max(take, notTake);
            }
        }
        return dp[maxWeight];
    }

}
