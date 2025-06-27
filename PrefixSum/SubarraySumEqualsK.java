package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    /**
     *
     * https://leetcode.com/problems/subarray-sum-equals-k
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        map.put(0,1);
        for(int n:nums) {
            currSum += n;
            if(map.containsKey(currSum- k)) {
                count = count + map.get(currSum-k);
            }
            map.put(currSum, map.getOrDefault(currSum,0)+1);
        }
        return count;
    }
}
