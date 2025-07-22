package MonotonicQueue;

import java.util.PriorityQueue;

public class MaxValueEquation {
    /**
     *
     * https://leetcode.com/problems/max-value-of-equation/
     * @param points
     * @param k
     * @return
     */
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        int max = Integer.MIN_VALUE;
        for(int []i:points) {
            int xj = i[0];
            int yj = i[1];

            while(!pq.isEmpty() && xj - pq.peek()[1] > k){
                pq.poll();
            }
            if(!pq.isEmpty()) {
                max = Math.max(max, pq.peek()[0] + yj+xj);
            }
            pq.offer(new int[]{yj-xj,xj});
        }
        return max;
    }

}
