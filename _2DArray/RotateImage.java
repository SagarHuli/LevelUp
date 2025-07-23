package _2DArray;

public class RotateImage {

    /**
     * https://leetcode.com/problems/rotate-image/submissions/1708794050/
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n= matrix.length;
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0;i<n;i++){
            int low = 0, high = n-1;
            while(low<high) {
                int temp = matrix[i][high];
                matrix[i][high] = matrix[i][low];
                matrix[i][low] = temp;
                low++;
                high--;
            }
        }
    }
}
