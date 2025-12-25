package DP._2D_DP;

public class CountSquareSubmatricesWithAllOnes {

    /*
    https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
     */
    public int countSquares(int[][] matrix) {
        int total = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] ==1) {
                    if(i>0 && j>0) {
                        dp[i][j] = 1+ Math.min(
                                Math.min(dp[i][j-1], dp[i-1][j]),
                                dp[i-1][j-1]);
                    } else {
                        dp[i][j] = matrix[i][j];
                    }
                    total += dp[i][j];
                }
            }
        }
        return total;
    }
}
