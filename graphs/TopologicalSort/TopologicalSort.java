package graphs.TopologicalSort;

import java.util.*;

public class TopologicalSort {

    /*
    https://www.geeksforgeeks.org/problems/topological-sort/1
     */
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int [] edge : edges) {
            adj.computeIfAbsent(edge[0], x-> new ArrayList<>()).add(edge[1]);
        }

        for(int i=0; i<V;i++) {
            if(!visited[i]) {
                dfs(i, edges, stack, visited, adj);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private void dfs(int node, int[][] edges, Stack<Integer> stack,
                     boolean[] visited, Map<Integer, List<Integer>> adj) {
        visited[node] = true;
        if(adj.containsKey(node)) {
            for(int neighbor: adj.get(node)) {
                if(!visited[neighbor]) {
                    dfs(neighbor, edges, stack, visited, adj);
                }
            }
        }
        stack.push(node);
    }
}
