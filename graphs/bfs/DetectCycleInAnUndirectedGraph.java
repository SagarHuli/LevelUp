package graphs.bfs;

import java.util.*;

public class DetectCycleInAnUndirectedGraph {

    /*
    https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph
     */
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        boolean [] visited = new boolean[V];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int [] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        Map<Integer,Integer> parent = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                queue.offer(i);
                parent.put(i, -1);
                visited[i] = true;
                while(!queue.isEmpty()) {
                    int edge = queue.poll();

                    if(adj.containsKey(edge)) {
                        for(Integer neighbor : adj.get(edge)) {
                            if(!visited[neighbor]) {
                                queue.offer(neighbor);
                                parent.put(neighbor, edge);
                                visited[neighbor] = true;
                            }
                            else {
                                if (!neighbor.equals(parent.get(edge))) {
                                    return true;
                                }
                            }
                        }
                    }

                }
            }
        }

        return false;
    }
}
