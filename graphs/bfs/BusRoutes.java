package graphs.bfs;

import java.util.*;

public class BusRoutes {
    /*
    https://leetcode.com/problems/bus-routes/
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        Map<Integer, List<Integer>> stopToRoutesMap = new HashMap<>();
        for(int i=0; i< routes.length; i++) {
            for(int stop : routes[i]) {
                if(!stopToRoutesMap.containsKey(stop)) {
                    stopToRoutesMap.put(stop, new ArrayList<>());
                }
                stopToRoutesMap.get(stop).add(i);
            }
        }

        boolean [] visited = new boolean[routes.length];
        Queue<int []> queue = new LinkedList<>();
        for(int route : stopToRoutesMap.getOrDefault(source, new ArrayList<>())) {
            queue.offer(new int[]{route, 1});
            visited[route] = true;
        }

        while(!queue.isEmpty()) {
            int [] polled = queue.poll();
            int routeIndex = polled[0];
            int nBusTaken = polled[1];

            for(int stop : routes[routeIndex]) {
                if(stop == target) return nBusTaken;
                for(int nextStop : stopToRoutesMap.getOrDefault(stop, new ArrayList<>())) {
                    if(!visited[nextStop]) {
                        visited[nextStop] = true;
                        queue.offer(new int[]{nextStop, nBusTaken+1});
                    }
                }
            }

        }
        return -1;
    }
}
