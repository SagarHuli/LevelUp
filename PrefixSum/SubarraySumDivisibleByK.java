package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumDivisibleByK {
    /**
     https://leetcode.com/problems/subarray-sums-divisible-by-k
     */
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        for(int n:nums) {
            sum+=n;
            int remainder = sum % k;

            // negative number % K will be (negative number % K) +K
            if(remainder < 0) {
                remainder += k;
            }
            if(map.containsKey(remainder)) {
                count += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder,0)+1);
        }
        return count;
    }
}
