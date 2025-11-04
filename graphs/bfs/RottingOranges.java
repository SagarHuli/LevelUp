package graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    /*
    https://leetcode.com/problems/rotting-oranges/
     */
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                } else if(grid[i][j] == 1) freshCount++;
            }
        }
        return bfs(grid, queue, freshCount);
    }

    private int bfs(int [][]grid, Queue<int[]> queue, int freshCount) {
        int m = grid.length;
        int n = grid[0].length;
        int time = 0;
        while(!queue.isEmpty() && freshCount > 0) {
            time++;
            int size = queue.size();
            for(int idx=0;idx<size;idx++) {
                int[] pop = queue.poll();
                int i = pop[0];
                int j = pop[1];
                int [][]dirs = {{i+1, j}, {i-1, j}, {i, j+1}, {i, j-1}};
                for(int[] dir : dirs) {
                    int newI = dir[0];
                    int newJ = dir[1];
                    if(newI <0 || newJ<0 || newI>=m || newJ>=n ||
                            grid[newI][newJ]!=1 ) continue;
                    grid[newI][newJ] = 2;
                    queue.offer(new int[]{newI, newJ});
                    freshCount--;
                }
            }
        }
        return freshCount ==0 ?time : -1;
    }
}
