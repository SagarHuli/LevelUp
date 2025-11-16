package graphs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInAGridWithObstacleElimination {
    /*
    https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
     */
    public int shortestPath(int[][] grid, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,k});
        int level = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean [][][]visited = new boolean[m][n][k+1];
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] current = queue.poll();
                if(current[0] == m-1 && current[1] == n-1) return level;

                for(int [] dir : getDirs(current, m, n)) {
                    int curI = dir[0];
                    int curJ = dir[1];
                    int el = dir[2];
                    if(grid[curI][curJ] == 0 && !visited[curI][curJ][el]) {
                        queue.offer(dir);
                        visited[curI][curJ][el] = true;
                    }
                    else if(el > 0 && !visited[curI][curJ][el-1]) {
                        queue.offer(new int[]{dir[0],dir[1],el-1});
                        visited[curI][curJ][el-1] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private List<int[]> getDirs(int[] curr, int m, int n) {
        int [][] possibleDirs = {{0,1}, {1,0}, {-1,0},{0,-1}};
        List<int[]> ret = new ArrayList<>();
        for(int []dir : possibleDirs) {
            int i = curr[0] + dir[0];
            int j = curr[1] + dir[1];
            int k = curr[2];
            if(i>=0 && j>=0 && i < m && j< n) {
                ret.add(new int[]{i, j, k});
            }
        }
        return ret;
    }
}
