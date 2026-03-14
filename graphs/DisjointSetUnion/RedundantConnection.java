package graphs.DisjointSetUnion;

public class RedundantConnection {

    /*
    https://leetcode.com/problems/redundant-connection/description/
     */
    static class DSU {
        int[] parent;
        int[] rank;
        int[] ans;
        public DSU(int n) {
            this.parent = new int[n+1];
            this.rank = new int[n+1];
            this.ans=new int[2];
            for(int i=0;i<=n;i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        public int[] getAns() {
            return this.ans;
        }
        public int findUltimateParent(int node) {
            if(node == parent[node]) return node;
            parent[node] = findUltimateParent(parent[node]);
            return parent[node];
        }

        public void findUnionByRank(int u, int v) {
            int ulpU = findUltimateParent(u);
            int ulpV = findUltimateParent(v);
            if(ulpU==ulpV) {
                ans[0] = u;
                ans[1] = v;
                return;
            }
            if(rank[ulpU] < rank[ulpV]) {
                parent[ulpU] = ulpV;
            } else if(rank[ulpV] < rank[ulpU]) {
                parent[ulpV] = ulpU;
            } else {
                parent[ulpU] = ulpV;
                rank[ulpV]++;
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);
        for(int [] edge : edges) {
            dsu.findUnionByRank(edge[0], edge[1]);
        }
        return dsu.getAns();
    }
}
