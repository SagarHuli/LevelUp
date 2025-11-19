package ShortestPath;

import java.util.*;

public class CheapestFlightsWithinKStops {
    /*
    https://leetcode.com/problems/cheapest-flights-within-k-stops/submissions/1834254976/
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] i : flights) {
            if (!adj.containsKey(i[0])) {
                adj.put(i[0], new ArrayList<>());
            }
            adj.get(i[0]).add(new int[] { i[1], i[2] });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { 0, src, 0 });
        // minCost[city][stops_taken] stores the minimum cost found so far
        int[][] minCost = new int[n][k + 2]; // K+1 flights (0 to K+1)
        for (int[] row : minCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minCost[src][0] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int node = cur[1];
            int stop = cur[2];
            if (node == dst)
                return cost;

            if (stop <= k) {
                for (int[] neighbour : adj.getOrDefault(node, new ArrayList<>())) {
                    int nextCity = neighbour[0];
                    int flightCost = neighbour[1];
                    int newCost = cost + flightCost;
                    int newStop = stop + 1;
                    if (newCost < minCost[nextCity][newStop]) {
                        minCost[nextCity][newStop] = newCost;
                        pq.offer(new int[] { newCost, nextCity, newStop });
                    }
                }
            }

        }
        return -1;
    }
}
