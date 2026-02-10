package graphs.DisjointSetUnion;

public class NumberOfProvincesV2 {

    class DisjointSet {
        int[] parent, rank;
        public DisjointSet(int n) {
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

    public int findCircleNum(int[][] isConnected) {
        DisjointSet dsu = new DisjointSet(isConnected.length);
        for(int i=0; i<isConnected.length; i++) {
            for(int j=0; j< isConnected[0].length; j++) {
                if(isConnected[i][j] == 1 && dsu.findUltimateParent(i) != dsu.findUltimateParent(j)) {
                    dsu.findByUnionByRank(i,j);
                }
            }
        }
        int count = 0;
        int [] parent = dsu.getParent();
        for(int i=0; i<parent.length; i++) {
            if(i == parent[i]) count++;
        }
        return count;
    }
}
