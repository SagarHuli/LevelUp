package SlidingWindowFixedLength;

import java.util.HashSet;
import java.util.Set;

public class MaxSumOfDistinctSubarraysWithSumK {
     /*
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0L;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<k;i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        int len = nums.length;
        for(int i=0;i<len-k;i++) {
            sum = Math.max(sum, mapSum(map));
            map.put(nums[i], map.getOrDefault(nums[i],0)-1);
            map.put(nums[i+k], map.getOrDefault(nums[i+k],0)+1);
        }
            sum = Math.max(sum, mapSum(map));
        return sum;
    }

    private static long mapSum(Map<Integer,Integer> map) {
        long sum = 0L;
        boolean isRepeat =
        map.values().stream().mapToInt(Integer::intValue).anyMatch(a -> a>1);
        if(isRepeat)
            return sum;

       for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
        if(entry.getValue()==1){
            sum+= entry.getKey();
        }
       }
       return sum;
    }
    */

    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int left=0, right=0;
        int n = nums.length;
        long maxSum = 0, sum=0;
        while(right< n) {
            while(set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            set.add(nums[right]);
            sum+= nums[right];
            right++;
            if(right - left ==k){
                maxSum = Math.max(sum, maxSum);
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
        }
        return maxSum;

    }
}
