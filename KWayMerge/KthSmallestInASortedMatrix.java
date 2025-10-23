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
}
