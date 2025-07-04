package HashTable;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    /**
     https://leetcode.com/problems/longest-consecutive-sequence
     */
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++)
            set.add(nums[i]);

        int longestStreak = 1;
        for(int n : set) {
            if(!set.contains(n-1)) {
                int current = n;
                int currentStreak = 1;
                while(set.contains(current+1)) {
                    current+=1;
                    currentStreak+=1;
                }
                longestStreak = Math.max(currentStreak, longestStreak);
            }
        }
        return longestStreak;
    }
}
