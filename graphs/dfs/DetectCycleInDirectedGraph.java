package graphs.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectCycleInDirectedGraph {

    /*
    https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
     */
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int [] edge : edges) {
            adj.computeIfAbsent(edge[0], k-> new ArrayList<>()).add(edge[1]);
        }

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for(int i=0; i<V;i++) {
            if(!visited[i]) {
                if(dfs(i, visited, pathVisited, adj)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int v, boolean[] visited, boolean[] pathVisited,
                        Map<Integer, List<Integer>> adj) {
        visited[v] = true;
        pathVisited[v] = true;

        if(adj.containsKey(v)) {
            for(int neighbor : adj.get(v)) {
                if(!visited[neighbor]) {
                    if(dfs(neighbor, visited, pathVisited, adj)) return true;
                }
                else {
                    if(pathVisited[neighbor]) return true;
                }
            }
        }
        pathVisited[v] = false;
        return false;
    }
}
