package graphs.DisjointSetUnion;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {

    List<Integer> parent = new ArrayList<>();
    List<Integer> size =  new ArrayList<>();

    DisjointSet(int n) {
        for(int i=0; i<=n;i++) {
            parent.add(i);
            size.add(1);
        }
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
        if(size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Main {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1,2);
        ds.unionBySize(2,3);
        ds.unionBySize(4,5);
        ds.unionBySize(6,7);
        ds.unionBySize(5,6);

        // if 3 and 7 belong to same group
        if(ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same Parent");
        } else  {
            System.out.println("Different Parent");
        }

        ds.unionBySize(3,7);
        // if 3 and 7 belong to same group
        if(ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same Parent");
        } else  {
            System.out.println("Different Parent");
        }
    }
}