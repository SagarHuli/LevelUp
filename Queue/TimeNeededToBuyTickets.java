package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToBuyTickets {
    /**
     * https://leetcode.com/problems/time-needed-to-buy-tickets/submissions/1702510311/
     * @param tickets
     * @param k
     * @return
     */
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int []> q = new LinkedList<>();
        for(int i=0;i<tickets.length;i++) {
            q.offer(new int[]{i,tickets[i]});
        }
        int count = 0;
        while(!q.isEmpty()) {
            int [] polled = q.poll();
            polled[1]--;
            count++;
            if(polled[0]==k && polled[1]==0)
                break;
            if(polled[1]>0)
                q.offer(polled);
        }
        return count;
    }
}
