package graphs.bfs;

import java.util.*;

public class AllPathsFromSourceToTarget {

    /*
    https://leetcode.com/problems/all-paths-from-source-to-target/
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(0));

        while(!queue.isEmpty()) {
            List<Integer> currPath = queue.poll();
            int lastIndex = currPath.get(currPath.size()-1);
            if(lastIndex == graph.length-1) {
                paths.add(new ArrayList<>(currPath));
            } else {
                for(int neighbour : graph[lastIndex]) {
                    List<Integer> newPath = new ArrayList<>(currPath);
                    newPath.add(neighbour);
                    queue.offer(newPath);
                }
            }
        }

        return paths;
    }
}
