package HashTable;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;
        for(int i=0;i<nums.length;i++) {
            int curr = map.getOrDefault(nums[i],0);
            total+=curr;
            map.put(nums[i], curr+1);
        }
        return total;
    }
}
