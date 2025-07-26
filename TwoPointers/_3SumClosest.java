package TwoPointers;

import java.util.Arrays;

public class _3SumClosest {

    /**
     * https://leetcode.com/problems/3sum-closest
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int ret = 0;
        for(int i=0;i<nums.length-2;i++) {
            int left = i+1, right = nums.length-1;
            while(left<right) {
                int sum = nums[i]+ nums[left]+nums[right];
                if(Math.abs(sum-target)<closest){
                    closest = Math.abs(sum-target);
                    ret = sum;
                }
                if(sum<target)
                    left++;
                else
                    right--;
            }
        }
        return ret;
    }
}
