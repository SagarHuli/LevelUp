package graphs.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {
    /*
    https://leetcode.com/problems/making-a-large-island/
     */
    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> colorMap = new HashMap<>();
        int color = 2;
        int maxSize = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid.length;j++) {
                if(grid[i][j] == 1) {
                    int size = dfs(grid, colorMap, i, j, grid.length, color, 0);
                    colorMap.put(color, size);
                    maxSize = Math.max(maxSize, size);
                    color++;
                }
            }
        }

        int len = grid.length;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid.length;j++) {
                int nodes = 0;
                if(grid[i][j] == 0) {
                    int [][]dirs = {{i+1, j}, {i-1, j}, {i, j+1}, {i, j-1}};
                    Set<Integer> set = new HashSet<>();
                    for(int [] dir : dirs){
                        int newI = dir[0];
                        int newJ = dir[1];
                        if(newI <0 || newJ<0 || newI >= len || newJ >= len) continue;
                        if(!set.contains(grid[newI][newJ])) {
                            nodes += colorMap.getOrDefault(grid[newI][newJ],0);
                            set.add(grid[newI][newJ]);
                        }
                    }
                    nodes++;
                    maxSize = Math.max(maxSize, nodes);
                }
            }
        }
        return maxSize;
    }

    private int dfs(int[][] grid, Map<Integer, Integer> map, int row, int col, int n, int color, int size) {
        if (row < 0 || col < 0 || row >= n || col >= n || grid[row][col] != 1)
            return size;
        int[][] dirs = { { row + 1, col }, { row - 1, col }, { row, col + 1 }, { row, col - 1 } };
        grid[row][col] = color;
        size++;
        for (int[] dir : dirs) {
            size = dfs(grid, map, dir[0], dir[1], n, color, size);
        }
        return size;
    }
}
