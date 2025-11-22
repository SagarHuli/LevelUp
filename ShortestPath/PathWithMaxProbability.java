package ShortestPath;

import java.util.*;

public class PathWithMaxProbability {
    /*
    https://leetcode.com/problems/path-with-maximum-probability/description/
     */
    class Pair {
        int node;
        double path;

        public Pair(int node, double path) {
            this.node = node;
            this.path = path;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<double[]>> adj = new HashMap<>();
        for(int i=0; i<edges.length; i++) {
            if(!adj.containsKey(edges[i][0])) {
                adj.put(edges[i][0], new ArrayList<>());
            }
            if(!adj.containsKey(edges[i][1])) {
                adj.put(edges[i][1], new ArrayList<>());
            }
            adj.get(edges[i][0]).add(new double[]{edges[i][1], succProb[i]});
            adj.get(edges[i][1]).add(new double[]{edges[i][0], succProb[i]});
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> b.path - a.path > 0.0 ? 1 : -1);
        boolean [] visited = new boolean[n];
        queue.offer(new Pair(start_node, 1));

        while(!queue.isEmpty()) {
            Pair poll = queue.poll();
            if(poll.node == end_node) return poll.path;
            visited[poll.node] = true;
            for(double[] next : adj.getOrDefault(poll.node, new ArrayList<>())) {
                int nextNode = (int) next[0];
                double nextPath = next[1];
                double nextCost = poll.path * nextPath;
                if(!visited[nextNode]) {
                    queue.offer(new Pair(nextNode, nextCost));
                }

            }
        }
        return 0;
    }
}
