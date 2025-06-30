package SlidingWindowDynamicLength;

import java.util.HashSet;
import java.util.Set;

public class LongestSubarrayWithoutRepeatingChars {
    /**
     https://leetcode.com/problems/longest-substring-without-repeating-characters
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        int i=0, j=0;
        int n = s.length();
        while(i<n && j<n) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, j-i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
