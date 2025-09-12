package BinarySearch;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length-1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(matrix[mid][0] == target){
                return true;
            }
            else if(target < matrix[mid][0]) {
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        int row = Math.max(high, 0);
        low = 0;
        high = matrix[0].length-1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(matrix[row][mid]==target){
                return true;
            } else if(target < matrix[row][mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return false;
    }
}
