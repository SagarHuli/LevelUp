package Heaps;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    /*
    https://leetcode.com/problems/k-closest-points-to-origin/
     */
    public int[][] kClosest(int[][] points, int k) {
        int[][] closest = new int[k][2];
        PriorityQueue<int[]> pq=  new PriorityQueue<>((a, b) -> b[1]-a[1]);
        for(int i=0; i< points.length; i++) {
            int dis = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.offer(new int[]{i, dis});
            if(pq.size() > k) pq.poll();
        }

        int j=0;
        while(!pq.isEmpty()) {
            int[] point = pq.poll();
            closest[j++] = points[point[0]];
        }
        return closest;
    }
}
