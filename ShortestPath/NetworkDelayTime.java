package ShortestPath;

import java.util.*;

public class NetworkDelayTime {
    /*
    https://leetcode.com/problems/network-delay-time/description/

    Dijkstra
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for(int[] i : times) {
            if(!adj.containsKey(i[0])) {
                adj.put(i[0], new ArrayList<>());
            }
            adj.get(i[0]).add(new ArrayList<>(Arrays.asList(i[1],i[2])));
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        pq.offer(new int[]{0, k});
        int min = 0;
        Set<Integer> visited = new HashSet<>();
        while(!pq.isEmpty()) {
            int [] pop = pq.poll();
            int path = pop[0];
            int node = pop[1];
            if(visited.contains(node)) continue;
            min = Math.max(min, path);
            visited.add(node);
            for(List<Integer> neighbour : adj.getOrDefault(node, new ArrayList<>())) {
                if(!visited.contains(neighbour.get(0))) {
                    pq.offer(new int[]{path + neighbour.get(1), neighbour.get(0)});
                }
            }
        }
        return visited.size() == n ? min : -1;
    }
}
