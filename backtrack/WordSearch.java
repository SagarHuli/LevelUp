package backtrack;

public class WordSearch {

    /*
    https://leetcode.com/problems/word-search/description/
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m;i++) {
            for(int j=0; j<n;j++) {
                if(backtrack(board, word, 0, i, j, new boolean[m][n])) return true;
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, String word, int index, int i, int j, boolean[][] isSeen) {
        if(index == word.length()) return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length ||
                isSeen[i][j] || board[i][j] != word.charAt(index)) return false;

        isSeen[i][j] = true;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean isFound = false;
        for(int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            isFound|= backtrack(board, word, index+1, newI, newJ, isSeen);
        }
        isSeen[i][j] = false;
        return isFound;
    }
}
