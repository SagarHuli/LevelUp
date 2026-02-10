package graphs.DisjointSetUnion;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumSpanningTree {

    /*
    https://www.geeksforgeeks.org/problems/minimum-spanning-tree-kruskals-algorithm/1
     */

    static int kruskalsMST(int V, int[][] edges) {
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));

        int weight = 0, count = 0;
        DisjointSet dsu = new DisjointSet(V);

        for(int [] edge : edges) {
            int u = edge[0], v = edge[1], cost = edge[2];
            if(dsu.findUltimateParent(u) != dsu.findUltimateParent(v)) {
                dsu.unionBySize(u,v);
                weight += cost;
                if(++count == V-1) break;
            }
        }

        return weight;
    }
}
