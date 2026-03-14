package backtrack;

public class MinimumMovesToSpreadStonesOverGrid {

    /*
    https://leetcode.com/problems/minimum-moves-to-spread-stones-over-grid/
     */
    public int minimumMoves(int[][] grid) {
        int r = -1, c = -1;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(grid[i][j] == 0) {
                    r = i;
                    c = j;
                    break;
                }
            }
        }
        if(r == -1) return 0;

        int minMoves = Integer.MAX_VALUE;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3;j++) {
                if(grid[i][j] > 1) {
                    grid[i][j]--;
                    grid[r][c]=1;

                    int dist = Math.abs(i-r) + Math.abs(j-c);
                    int res = minimumMoves(grid);
                    if(res != Integer.MAX_VALUE) {
                        minMoves = Math.min(minMoves, dist+res);
                    }

                    grid[i][j]++;
                    grid[r][c]=0;
                }
            }
        }
        return minMoves;
    }
}
