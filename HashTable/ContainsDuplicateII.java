package HashTable;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    /**
     * https://leetcode.com/problems/contains-duplicate-ii
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean ret = false;
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                ret = i - map.get(nums[i]) <= k;
                if(ret)
                    return true;
            }
            map.put(nums[i],i);
        }
        return ret;
    }
}
