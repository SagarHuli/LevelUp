package ShortestPath;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimInRisingWater {
    /*
    https://leetcode.com/problems/swim-in-rising-water/submissions/1836562413/
     */
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
        pq.offer(new int[]{0,0,grid[0][0]});
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] visited = new boolean[n][n];
        while(!pq.isEmpty()) {
            int [] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];
            int time = curr[2];
            if(i==n-1 && j==n-1) return time;
            visited[i][j] = true;
            for(int[] dir : dirs) {
                int newI = i + dir[0];
                int newJ = j + dir[1];
                if(newI <0 || newJ < 0 || newI>= n
                        || newJ>=n || visited[newI][newJ]) continue;
                pq.offer(new int[]{newI,newJ, Math.max(time, grid[newI][newJ])});
            }
        }
        return 0;
    }
}
