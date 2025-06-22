public class NumberOfZeroFilledSubArrays {
    /**
     https://leetcode.com/problems/number-of-zero-filled-subarrays
     */
    public long zeroFilledSubarray(int[] nums) {
        long total = 0;
        int i=0;
        int l = nums.length;
        while(i<l) {
            long z = 0;
            while(i<l &&nums[i] == 0) {
                z++;
                i++;
            }
            i++;
            total = total + (z*(z+1)/2);
        }
        return total;
    }
}
