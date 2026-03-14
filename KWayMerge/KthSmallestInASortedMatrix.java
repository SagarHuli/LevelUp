package KWayMerge;

import java.util.PriorityQueue;

public class KthSmallestInASortedMatrix {

    /*
    https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        for(int i=0;i<n;i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }

        int count = 0;
        int result= 0;
        while(count < k) {
            int [] current = pq.poll();
            result = current[0];
            int row = current[1];
            int col = current[2];

            if(col + 1 < n) {
                pq.offer(new int[]{matrix[row][col+1], row, col+1});
            }
            count++;
        }
        return result;
    }

    ///  Optimised with binary search
    public int kthSmallestV2(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(countLessThanOrEqualToTarget(matrix, mid) < k) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }

    private int countLessThanOrEqualToTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int row = n-1;
        int col = 0;
        int count = 0;
        while(row >=0 && col < n) {
            if(matrix[row][col] <= target) {
                count += row+1;
                col++;
            } else {
                row--;
            }
        }
        return count;
    }
}
