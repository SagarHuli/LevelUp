package graphs.dfs;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    /*
    https://leetcode.com/problems/all-paths-from-source-to-target/
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, paths, path, 0,graph.length-1);
        return paths;
    }

    private void dfs(int[][] graph, List<List<Integer>> paths,
                     List<Integer> currPath, int currIndex, int n) {
        if(currIndex == n) {
            paths.add(new ArrayList<>(currPath));
            return;
        }
        for(int i=0;i<graph[currIndex].length;i++) {
            currPath.add(graph[currIndex][i]);
            dfs(graph, paths, currPath, graph[currIndex][i], n);
            currPath.remove(currPath.size()-1);
        }
    }
}
