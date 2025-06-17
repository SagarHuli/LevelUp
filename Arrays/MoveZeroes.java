package LevelUp.Arrays;

/*
https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if(nums.length >1){
            int zeroes = 0;
            int j=0;
            for(int i=0;i<len;i++) {
                if(nums[i]==0)
                    zeroes++;
                else {
                    nums[j++] = nums[i];
                }
            }
            while(zeroes-- >0) {
                nums[j++] = 0;
            }
        }
    }
}
