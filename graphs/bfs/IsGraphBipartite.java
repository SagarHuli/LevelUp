package graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    /*
    https://leetcode.com/problems/is-graph-bipartite/submissions/1814050984/
     */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neighbour : graph[node]) {
                        if (color[neighbour] != 0) {
                            if (color[neighbour] != -color[node]) {
                                return false;
                            }
                        } else {
                            color[neighbour] = -color[node];
                            queue.offer(neighbour);
                        }
                    }
                }
            }
        }
        return true;
    }
}
