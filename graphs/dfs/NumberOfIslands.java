package graphs.dfs;

public class NumberOfIslands {
    /*
    https://leetcode.com/problems/number-of-islands/
     */
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]== '1') {
                    dfs(grid, i,j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char [][]matrix, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(i<0 || j < 0 || i>=m || j >= n || matrix[i][j]=='0')
            return;
        matrix[i][j] = '0';
        dfs(matrix, i+1, j);
        dfs(matrix, i-1, j);
        dfs(matrix, i, j+1);
        dfs(matrix, i, j-1);
    }
}
