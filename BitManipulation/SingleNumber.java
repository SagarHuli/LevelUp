package BitManipulation;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        /**
         https://leetcode.com/problems/single-number
         [4,1,2,1,2]
         100
         001
         010
         001
         010
         XOR returns false if both bits are same.
         */

        int single = nums[0];
        for(int i=1;i<nums.length;i++) {
            single^=nums[i];
        }
        return single;
    }
}
