package ShortestPath;

import java.util.*;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {

    /*
    https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
     */
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] edge: edges) {
            adj.computeIfAbsent(edge[0], x-> new ArrayList<>());
            adj.computeIfAbsent(edge[1], x-> new ArrayList<>());
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[1] > b[1]) return 1;
            else if(a[1] < b[1]) return -1;
            else return a[0] > b[0] ? -1: 1;
        });

        for(int i=0; i<n; i++) {
            int reachable = getReachable(i,n, adj, distanceThreshold);
            pq.offer(new int[]{i, reachable});
        }
        return pq.peek()[0];
    }

    private static int getReachable(int startNode, int n, Map<Integer, List<int[]>> adj, int threshold) {
        // Stores the shortest distance found so far to each city
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[startNode] = 0;

        // PriorityQueue stores {cityIndex, currentDistance}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{startNode, 0});

        int reachableCount = 0;
        // Track truly visited nodes to avoid double counting
        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (visited[u]) continue;
            visited[u] = true;

            // Count this city if it's within threshold (and not the starting city)
            if (u != startNode) reachableCount++;

            if (!adj.containsKey(u)) continue;

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                // If we found a shorter path to 'v' within the threshold
                if (d + weight <= threshold && d + weight < minDist[v]) {
                    minDist[v] = d + weight;
                    pq.offer(new int[]{v, minDist[v]});
                }
            }
        }
        return reachableCount;
    }


    //optimised Floyd-Warshall algo

    public int findTheCityV2(int n, int[][] edges, int distanceThreshold) {
        // 1. Initialize distance matrix with "infinity"
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 10001); // Threshold is max 10^4, so 10001 is enough
            dist[i][i] = 0;
        }

        // 2. Fill initial weights from edges
        for (int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }

        // 3. Floyd-Warshall Algorithm (Shortest path for all pairs)
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 4. Count reachable cities for each city and find the best candidate
        int minReachableCount = n;
        int resultCity = -1;

        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }

            // Rule: Smallest number of cities. If tie, return city with greatest index.
            if (reachableCount <= minReachableCount) {
                minReachableCount = reachableCount;
                resultCity = i;
            }
        }

        return resultCity;
    }
}
