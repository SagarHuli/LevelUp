package graphs.DisjointSetUnion;

public class ConnectingTheGraph {

    /*
    https://www.geeksforgeeks.org/problems/connecting-the-graph/1
     */

    public int Solve(int n, int[][] edge) {
        DSU dsu = new DSU(n);
        int extra = 0;
        for(int [] e: edge) {
            int u = e[0];
            int v = e[1];
            if(dsu.getUltimateParent(u) == dsu.getUltimateParent(v)) {
                extra++;
            } else {
                dsu.unionByRank(u,v);
            }
        }

        int ulp = 0;
        int [] parent = dsu.getParent();
        for(int i=0; i<parent.length;i++) {
            if(i == parent[i]) ulp++;
        }
        return extra >= ulp-1 ? ulp-1 : -1;
    }
}

class DSU {
    int [] parent, rank;

    public DSU(int n) {
        this.parent = new int[n];
        this.rank = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int[] getParent() {
        return this.parent;
    }

    public int getUltimateParent(int node) {
        if(node == parent[node]) return node;
        parent[node] = getUltimateParent(parent[node]);
        return parent[node];
    }

    public void unionByRank(int u, int v){
        int ulpU = getUltimateParent(u);
        int ulpV = getUltimateParent(v);

        if(ulpU == ulpV) return;
        if(rank[ulpU] < rank[ulpV]) {
            parent[ulpU] = ulpV;
        } else if(rank[ulpV] < rank[ulpU]) {
            parent[ulpV] = ulpU;
        } else {
            parent[ulpV] = ulpU;
            rank[ulpU]++;
        }
    }
}