package greedy;

import java.util.PriorityQueue;

public class MinNumberOfRefuellingStops {
    /*
    https://leetcode.com/problems/minimum-number-of-refueling-stops/description/
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int stops = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        int i=0;
        while( startFuel < target) {
            while(i < stations.length && stations[i][0] <= startFuel) {
                maxHeap.offer(stations[i][1]);
                i++;
            }
            if(maxHeap.isEmpty()) return -1;
            startFuel += maxHeap.poll();
            stops++;
        }
        return stops;
    }
}
