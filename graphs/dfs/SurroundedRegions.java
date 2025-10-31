package graphs.dfs;

public class SurroundedRegions {
    /*
    https://leetcode.com/problems/surrounded-regions/
     */
    public void solve(char[][] board) {
        int [][] visited = new int[board.length][board[0].length];
        checkBoundary(board, visited);
        replaceOWithX(board, visited);
    }

    private void checkBoundary(char[][] board, int [][] visited) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++) {
            if(board[i][0] == 'O') {
                dfs(board, visited, i, 0);
            }
        }
        for(int i=0;i<n;i++) {
            if(board[0][i] == 'O') {
                dfs(board, visited, 0, i);
            }
        }
        for(int i=m-1;i>=0;i--) {
            if(board[i][n-1] == 'O') {
                dfs(board, visited, i, n-1);
            }
        }
        for(int i=n-1;i>=0;i--) {
            if(board[m-1][i] == 'O') {
                dfs(board, visited, m-1, i);
            }
        }
    }

    private void dfs(char[][] board, int [][] visited, int row, int col) {
        int m = board.length;
        int n = board[0].length;
        if(row>=m || col >= n || row <0 || col <0 ||
                board[row][col] != 'O' || visited[row][col] == 1) return;
        visited[row][col] = 1;
        dfs(board, visited, row+1, col);
        dfs(board, visited, row-1, col);
        dfs(board, visited, row, col+1);
        dfs(board, visited, row, col-1);
    }

    private void replaceOWithX(char[][] board, int [][] visited) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == 'O' && visited[i][j] != 1) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
