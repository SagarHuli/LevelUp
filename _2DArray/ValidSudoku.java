package _2DArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ValidSudoku {
    public boolean isValidSudokuV2(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentValue = board[i][j];
                if (currentValue != '.') {
                    // For each value, ensure it is unique in its row, column, and sub-grid
                    if (!seen.add(currentValue + " found in row " + i) ||
                            !seen.add(currentValue + " found in column " + j) ||
                            !seen.add(currentValue + " found in subgrid " + i/3 + "-" + j/3)) {
                        return false;  // If any of the adds return false, the board isn't valid
                    }
                }
            }
        }
        return true;
    }

    //works
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++) {
            List<Character> list = new ArrayList<>();
            for(int j=0;j<9;j++) {
                if(board[i][j]!='.') {
                    if(list.contains(board[i][j])) return false;
                    list.add(board[i][j]);
                }
            }
        }
        for(int i=0;i<9;i++) {
            List<Character> list = new ArrayList<>();
            for(int j=0;j<9;j++) {
                if(board[j][i]!='.') {
                    if(list.contains(board[j][i])) return false;
                    list.add(board[j][i]);
                }
            }
        }

        for(int i=0;i<9;i=i+3) {
            for(int j=0;j<9;j=j+3) {
                int a = i;
                int b = j;
                List<Character> list = new ArrayList<>();
                while(a<i+3) {
                    while(b<j+3) {
                        if(board[a][b]!='.') {
                            if(list.contains(board[a][b])) return false;
                            list.add(board[a][b]);
                        }
                        b++;
                    }
                    b= j;
                    a++;
                }
            }
        }
        return true;
    }
}
