package backtrack;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    /*
    https://leetcode.com/problems/n-queens/submissions/1843486096/
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] base = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                base[i][j] = '.';
            }
        }
        backtrack(result, n, base, 0);
        return result;
    }

    private static void backtrack(List<List<String>> result, int n, char[][] base, int row) {
        if (n == 0) {
            List<String> res = new ArrayList<>();
            for (char[] chAr : base) {
                String str = new String(chAr);
                res.add(str);
            }
            result.add(res);
        }
        if (row == base.length)
            return;
        for (int j = 0; j < base.length; j++) {
            if (isPossible(base, row, j)) {
                base[row][j] = 'Q';
                backtrack(result, n - 1, base, row + 1);
                base[row][j] = '.';
            }
        }
    }

    private static boolean isPossible(char[][] base, int row, int col) {
        int i = row;
        int j = col;
        int size = base.length;
        while (i >= 0) {
            if (base[i][j] == 'Q')
                return false;
            i--;
        }
        i = row;
        j = col;
        while (j >= 0) {
            if (base[i][j] == 'Q')
                return false;
            j--;
        }
        i = row;
        j = col;
        while (j < size) {
            if (base[i][j] == 'Q')
                return false;
            j++;
        }
        i = row;
        j = col;
        while (i < size) {
            if (base[i][j] == 'Q')
                return false;
            i++;
        }
        i = row;
        j = col;
        while (i < size && j < size) {
            if (base[i][j] == 'Q')
                return false;
            i++;
            j++;
        }
        i = row;
        j = col;
        while (i < size && j >= 0) {
            if (base[i][j] == 'Q')
                return false;
            i++;
            j--;
        }
        i = row;
        j = col;
        while (i >= 0 && j >= 0) {
            if (base[i][j] == 'Q')
                return false;
            i--;
            j--;
        }
        i = row;
        j = col;
        while (i >= 0 && j < size) {
            if (base[i][j] == 'Q')
                return false;
            i--;
            j++;
        }
        return true;
    }
}
