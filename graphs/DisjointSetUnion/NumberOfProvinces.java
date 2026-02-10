package graphs.DisjointSetUnion;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    class DisjointSet {

        List<Integer> parent = new ArrayList<>();
        List<Integer> size =  new ArrayList<>();
        int provinces;

        DisjointSet(int n) {
            this.provinces = n;
            for(int i=0; i<=n;i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int getProvinces() {
            return this.provinces;
        }
        public int findUltimateParent(int node) {
            if(node == parent.get(node)) return node;
            int ulp = findUltimateParent(parent.get(node));
            parent.set(node, ulp);
            return ulp;
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findUltimateParent(u);
            int ulp_v = findUltimateParent(v);
            if(ulp_u == ulp_v) return;
            provinces--;
            if(size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        DisjointSet dsu = new DisjointSet(isConnected.length);
        for(int i=0; i<isConnected.length; i++) {
            for(int j=0; j< isConnected[0].length; j++) {
                if(isConnected[i][j] == 1 && dsu.findUltimateParent(i) != dsu.findUltimateParent(j)) {
                    dsu.unionBySize(i,j);
                }
            }
        }
        return dsu.getProvinces();
    }
}
