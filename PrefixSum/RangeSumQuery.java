package PrefixSum;

public class RangeSumQuery {
    /**
     * https://leetcode.com/problems/range-sum-query-immutable
     */
    int [] prefix;
    public RangeSumQuery(int[] nums) {
        this.prefix = new int[nums.length+1];
        for(int i=0;i<nums.length;i++) {
            prefix[i+1] = nums[i]+prefix[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right+1] - prefix[left];
    }
}

/**
 * Your RangeSumQuery object will be instantiated and called as such:
 * RangeSumQuery obj = new RangeSumQuery(nums);
 * int param_1 = obj.sumRange(left,right);
 */
