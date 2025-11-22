package ShortestPath;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    /*
    https://leetcode.com/problems/path-with-minimum-effort/
     */
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a-> a[2]));
        pq.offer(new int[]{0,0,0});
        boolean [][] visited = new boolean[m][n];
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];
            int dist = curr[2];
            if(i == m-1 && j == n-1) return dist;

            visited[i][j] = true;
            for(int[] dir : dirs) {
                int newI = i + dir[0];
                int newJ = j + dir[1];
                if(newI <0 || newJ <0 || newI >=m || newJ>=n || visited[newI][newJ]) continue;
                pq.offer(new int[]
                        {newI, newJ, Math.max(Math.abs(heights[newI][newJ] - heights[i][j]), dist)});
            }
        }
        return 0;
    }
}
