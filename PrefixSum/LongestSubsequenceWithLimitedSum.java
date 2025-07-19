package PrefixSum;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {

    /**
     *
     * https://leetcode.com/problems/longest-subsequence-with-limited-sum/submissions/1703462023/
     * @param nums
     * @param queries
     * @return
     */
    public int[] answerQueries(int[] nums, int[] queries) {

        Arrays.sort(nums);
        int [] result = new int[queries.length];
        for(int i=1;i<nums.length;i++) {
            nums[i] = nums[i-1]+ nums[i];
        }

        for(int i=0;i<queries.length;i++) {
            int q = queries[i];
            int low = 0;
            int high = nums.length-1;
            while(low<=high) {
                int mid = low + (high-low)/2;
                if(nums[mid]==q) {
                    result[i] = mid+1;
                    break;
                } else if(nums[mid] < q) {
                    result[i] = mid+1;
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return result;
    }

}
