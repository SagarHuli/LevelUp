package BitManipulation;

public class SingleNumberIII {
    /**
     https://leetcode.com/problems/single-number-iii/description/
     */
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i=0;i<nums.length;i++) {
            xor = xor ^ nums[i];
        }
        //Find any bit that is set in the xor result (we'll use the rightmost bit)
        // x & x-1 is used to clear the rightmoset set bit of x
        // x & (-x) 2's complement of x is used to get the distinct bits at a rightmost postition
        int diff_bit = xor & (-xor);
        int ret[] = new int[2];
        for(int i=0;i<nums.length;i++) {
            if((diff_bit & nums[i])==0) {
                ret[0] = ret[0] ^ nums[i];
            }else {
                ret[1] = ret[1] ^ nums[i];
            }
        }
        return ret;
    }
}
