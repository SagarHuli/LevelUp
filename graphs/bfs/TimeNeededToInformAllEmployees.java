package graphs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TimeNeededToInformAllEmployees {

    /*
    https://leetcode.com/problems/time-needed-to-inform-all-employees/
     */
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> subordinates = new ArrayList<>();
        for(int i=0;i< n;i++) {
            subordinates.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++) {
            if(manager[i] != -1)
                subordinates.get(manager[i]).add(i);
        }

        int maxTime = 0;
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[]{headID, 0});
        while(!queue.isEmpty()) {
            int [] current = queue.poll();
            int currentId = current[0];
            int currentTime = current[1];
            maxTime = Math.max(maxTime, currentTime);
            for(int sub : subordinates.get(currentId)) {
                queue.offer(new int[]{sub, currentTime + informTime[currentId]});
            }
        }
        return maxTime;
    }
}
