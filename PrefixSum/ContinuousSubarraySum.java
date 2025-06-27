package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    /**
     https://leetcode.com/problems/continuous-subarray-sum/
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int curr = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++) {
            curr+= nums[i];
            int mod = curr % k;
            if(mod < 0) {
                mod+=k;
            }
            if(map.containsKey(mod)) {
                if(i - map.get(mod) > 1) {
                    return true;
                }
            } else
                map.put(mod, i);
        }
        return false;
    }
}
