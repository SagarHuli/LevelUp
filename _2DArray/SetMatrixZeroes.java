package _2DArray;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes {

    /**
     * https://leetcode.com/problems/set-matrix-zeroes/submissions/1709803174/
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        List<List<Integer>> track = new ArrayList<>();

        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j]==0)
                    track.add(List.of(i,j));
            }
        }
        for(int i=0;i<track.size();i++){
            List<Integer> zero = track.get(i);
            int x = zero.get(0);
            int y = zero.get(1);
            int a=0;
            int b=0;
            while(a<matrix.length) {
                matrix[a][y]=0;
                a++;
            }
            while(b<matrix[0].length) {
                matrix[x][b]=0;
                b++;
            }
        }
    }

}
