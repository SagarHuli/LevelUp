package graphs.DisjointSetUnion;

public class DisjointSetV2 {

    int[] parent, rank;
    public DisjointSetV2(int n) {
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
    public int findUltimateParent(int node) {
        if(parent[node] == node) return node;
        parent[node] = findUltimateParent(parent[node]);
        return parent[node];
    }

    public void findByUnionByRank(int u, int v) {
        int ulpU = findUltimateParent(u);
        int ulpV = findUltimateParent(v);
        if(ulpU == ulpV) return;
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
