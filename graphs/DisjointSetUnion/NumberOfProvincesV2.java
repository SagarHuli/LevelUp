package graphs.DisjointSetUnion;

public class NumberOfProvincesV2 {

    public int findCircleNum(int[][] isConnected) {
        DisjointSetV2 dsu = new DisjointSetV2(isConnected.length);
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
