package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    /**
     https://leetcode.com/problems/contiguous-arra
     */
    public int findMaxLength(int[] nums) {
        int max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int curr = 0;
        for(int i=0;i<nums.length;i++) {
            curr += nums[i] == 0? -1:1;
            if(map.containsKey(curr)) {
                int size = i - map.get(curr);
                max = Math.max(size, max);
            } else {
                map.put(curr, i);
            }
        }
        return max;
    }
}
