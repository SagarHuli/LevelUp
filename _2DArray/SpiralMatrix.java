package _2DArray;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    /**
     * https://leetcode.com/problems/spiral-matrix/
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int iTop=0,iBottom=matrix.length-1,jLeft=0,jRight=matrix[0].length-1;
        List<Integer> list = new ArrayList<>();
        while(iTop<=iBottom && jLeft<=jRight) {
            for(int i=jLeft;i<=jRight;i++) {
                list.add(matrix[iTop][i]);
            }
            iTop++;
            for(int i=iTop;i<=iBottom;i++) {
                list.add(matrix[i][jRight]);
            }
            jRight--;
            if(iTop<=iBottom) {
                for(int i=jRight;i>=jLeft;i--) {
                    list.add(matrix[iBottom][i]);
                }
                iBottom--;
            }
            if(jLeft<=jRight) {
                for(int i=iBottom;i>=iTop;i--) {
                    list.add(matrix[i][jLeft]);
                }
                jLeft++;
            }
        }
        return list;
    }
}
