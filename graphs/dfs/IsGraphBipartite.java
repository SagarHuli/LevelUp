package graphs.dfs;

public class IsGraphBipartite {
    /*
    https://leetcode.com/problems/is-graph-bipartite
     */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int [] color = new int[n];
        for(int i=0;i<n;i++) {
            if(color[i]==0 && !validBipartite(graph, color, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean validBipartite(int [][]graph, int[] color, int node, int expectedColor) {
        if(color[node] != 0) {
            return color[node] == expectedColor;
        }
        color[node] = expectedColor;
        for(int neighbour : graph[node]) {
            if(!validBipartite(graph, color, neighbour, -expectedColor))
                return false;
        }
        return true;
    }
}
