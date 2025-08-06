package MonotonicQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxNumberOfEventsThatCanBeAttended {
    /**
     https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/
     */
    public int maxEvents(int[][] events) {
        int count = 0;
        int max = 0;
        for(int [] ar : events)
            max = Math.max(max,ar[1]);
        Arrays.sort(events, (a, b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int len = events.length;
        int j=0;
        for(int i=1;i<=max;i++)  {
            while(j<len && events[j][0]<=i) {
                pq.offer(events[j][1]);
                j++;
            }
            while(!pq.isEmpty() && pq.peek() < i){
                pq.poll();
            }
            if(!pq.isEmpty()) {
                pq.poll();
                count++;
            }
        }
        return count;
    }
}
