package graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    /*
    https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length;
        boolean [][] visited = new boolean[n][n];

        queue.offer(new int[]{0,0});
        int distance = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for(int k = 0; k<size; k++) {
                int [] curr = queue.poll();
                int i = curr[0];
                int j = curr[1];
                if(i==n-1 && j==n-1) return distance;
                if(visited[i][j]) continue;
                visited[i][j] = true;
                int [][] dirs = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
                for(int [] dir : dirs) {
                    int newI = dir[0] + i;
                    int newJ = dir[1] + j;
                    if(newI<0 || newJ<0 || newI>=n ||
                            newJ>=n || visited[newI][newJ] || grid[newI][newJ] == 1) continue;
                    queue.offer(new int[]{newI,newJ});
                }
            }
        }
        return -1;
    }
}
