package TwoPointers;

public class SortArrayByParity {

    /*
    https://leetcode.com/problems/sort-array-by-parity/
     */
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left < right) {
            if(nums[left] % 2 == 1) {
                while(right >= left && nums[right] % 2 == 1) {
                    right--;
                }
                if(left < right) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left++;
                    right--;
                }

            } else {
                left++;
            }
        }
        return nums;
    }
}
