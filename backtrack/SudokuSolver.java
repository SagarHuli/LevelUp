package backtrack;

public class SudokuSolver {

    /*
    https://leetcode.com/problems/sudoku-solver/
     */
    public void solveSudoku(char[][] board) {
        int dots = 0;
        boolean[][] row = new boolean[10][10];
        boolean[][] col = new boolean[10][10];
        boolean[][] box = new boolean[10][10];

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.') {
                    int val = board[i][j]-'0';
                    row[i][val] = col[j][val] = box[(i/3)*3+(j/3)][val] = true;
                }
            }
        }
        backtrack(board, row, col, box, 0,0);
    }

    private boolean backtrack(char[][] board, boolean[][] row,
                              boolean[][] col, boolean[][] box, int r, int c) {
        if(c == 9) {
            c = 0;
            r++;
        }
        if(r == 9) return true;
        if(board[r][c] != '.') {
            return backtrack(board, row, col, box, r, c+1);
        }

        int boxId = (r/3)*3+(c/3);
        for(int i=1; i<=9; i++) {
            if(!row[r][i] &&
                    !col[c][i] &&
                    !box[boxId][i]) {
                board[r][c] = (char) (i+'0');
                row[r][i] = col[c][i] = box[boxId][i] = true;
                if(backtrack(board, row, col, box,r, c+1)) return true;
                board[r][c] = '.';
                row[r][i] = col[c][i] = box[boxId][i] = false;
            }
        }
        return false;
    }
}
