package graphs.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    /*
    https://leetcode.com/problems/pacific-atlantic-water-flow/
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int [][] pacific = new int[row][col];
        int [][] atlantic = new int [row][col];

        for(int i=0;i<row;i++) {
            dfs(heights, pacific, i,0);
            dfs(heights, atlantic, i, col-1);
        }

        for(int i=0;i<col;i++){
            dfs(heights, pacific, 0, i);
            dfs(heights, atlantic, row-1, i);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(atlantic[i][j] == 1 && pacific[i][j] == 1) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    private static void dfs(int [][]heights, int[][] ocean, int row, int col) {
        ocean[row][col] = 1;
        int [][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow <0 || newCol <0 || newRow >= heights.length ||
                    newCol >= heights[0].length ||
                    ocean[newRow][newCol] == 1 ||
                    heights[newRow][newCol] < heights[row][col]) continue;
            dfs(heights, ocean, newRow, newCol);
        }
    }
}
