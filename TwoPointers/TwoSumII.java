package TwoPointers;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        /**
         https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
         */
        int i=0;
        int j=numbers.length-1;
        int ret [] = new int[2];
        while(i<j) {
            if(numbers[i] + numbers[j] > target) {
                j--;
            }
            else if(numbers[i] + numbers[j] < target) {
                i++;
            }
            else {
                ret[0] = i+1;
                ret[1] = j+1;
                break;
            }
        }
        return ret;
    }
}
