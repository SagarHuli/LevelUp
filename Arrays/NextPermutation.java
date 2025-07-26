import java.util.Arrays;

public class NextPermutation {
    /**
     https://leetcode.com/problems/next-permutation/submissions/1712012628
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        while(i>0 && nums[i-1]>=nums[i]){
            i--;
        }
        i--;
        if(i==-1){
            Arrays.sort(nums);
            return;
        }
        int j=i;
        int max = nums[j];
        int leastDiff = Integer.MAX_VALUE;
        int second = 0;
        while(j<nums.length) {
            if(nums[j]-max>0 && nums[j]-max < leastDiff) {
                leastDiff = nums[j]-max;
                second = j;
            }
            j++;
        }
        int temp = nums[i];
        nums[i] = nums[second];
        nums[second] = temp;
        Arrays.sort(nums, i+1, nums.length);
    }
}
